package org.sagebionetworks.warehouse.workers.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.sagebionetworks.warehouse.workers.log.S3LoggerImpl.BUCKET_CONFIG_KEY;
import static org.sagebionetworks.warehouse.workers.log.S3LoggerImpl.TEMP_FILE_EXTENSION;
import static org.sagebionetworks.warehouse.workers.log.S3LoggerImpl.TEMP_FILE_NAME;

import java.io.File;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sagebionetworks.common.util.progress.ProgressCallback;
import org.sagebionetworks.warehouse.workers.collate.StreamResourceProvider;
import org.sagebionetworks.warehouse.workers.config.Configuration;
import org.sagebionetworks.warehouse.workers.model.LogRecord;
import org.sagebionetworks.warehouse.workers.utils.LogRecordUtils;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3LoggerImplTest {
	@Mock
	AmazonS3Client mockS3Client;
	@Mock
	StreamResourceProvider mockResourceProvider;
	@Mock
	Configuration mockConfig;
	@Mock
	ProgressCallback<Void> mockProgressCallback;
	@Mock
	File mockFile;
	@Mock
	PrintWriter mockWriter;
	
	ArgumentCaptor<PutObjectRequest> captor;
	S3LoggerImpl s3Logger;
	String bucketName = "test.warehouse.workers.log.sagebase.org";
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		when(mockConfig.getProperty(BUCKET_CONFIG_KEY)).thenReturn(bucketName);
		when(mockResourceProvider.createTempFile(TEMP_FILE_NAME, TEMP_FILE_EXTENSION)).thenReturn(mockFile);
		when(mockResourceProvider.createGzipPrintWriter(mockFile)).thenReturn(mockWriter);
		when(mockS3Client.doesBucketExist(any(String.class))).thenReturn(false);
		s3Logger = new S3LoggerImpl(mockS3Client, mockResourceProvider, mockConfig);
		captor = ArgumentCaptor.forClass(PutObjectRequest.class);
	}

	@Test
	public void testConstructor() {
		verify(mockConfig).getProperty(BUCKET_CONFIG_KEY);
		verify(mockS3Client).doesBucketExist(bucketName);
		verify(mockS3Client).createBucket(bucketName);
	}

	@Test
	public void testConstructorBucketExist() {
		reset(mockS3Client);
		when(mockS3Client.doesBucketExist(any(String.class))).thenReturn(true);
		s3Logger = new S3LoggerImpl(mockS3Client, mockResourceProvider, mockConfig);
		verify(mockS3Client, never()).createBucket(bucketName);
	}

	@Test
	public void testLog() {
		long timestamp = System.currentTimeMillis();
		Exception e = new Exception("test");
		LogRecord toLog = new LogRecord(timestamp, "workerName", e);
		s3Logger.log(mockProgressCallback, null, toLog);
		verify(mockResourceProvider).createTempFile(TEMP_FILE_NAME, TEMP_FILE_EXTENSION);
		verify(mockResourceProvider).createGzipPrintWriter(mockFile);
		verify(mockWriter).println(LogRecordUtils.getFormattedLog(toLog));
		verify(mockProgressCallback).progressMade(null);
		verify(mockS3Client).putObject(captor.capture());
		PutObjectRequest request = captor.getValue();
		assertNotNull(request);
		assertEquals(bucketName, request.getBucketName());
		// only check the prefix 00-00-00-000 (hh-mm-ss-mss)
		assertTrue(request.getKey().startsWith(LogRecordUtils.getKey(toLog).substring(0, 11)));
		assertEquals(mockFile, request.getFile());
		assertEquals(CannedAccessControlList.BucketOwnerFullControl, request.getCannedAcl());
		verify(mockWriter).flush();
		verify(mockWriter, times(2)).close();
	}
	
	@Test
	public void testInvalidLogRecord() {
		s3Logger.log(mockProgressCallback, null, null);
		verify(mockResourceProvider, never()).createTempFile(any(String.class), any(String.class));
		verify(mockResourceProvider, never()).createGzipPrintWriter(any(File.class));
		verify(mockProgressCallback, never()).progressMade(null);
		verify(mockS3Client, never()).putObject(any(PutObjectRequest.class));
		verify(mockWriter, never()).close();
	}
}
