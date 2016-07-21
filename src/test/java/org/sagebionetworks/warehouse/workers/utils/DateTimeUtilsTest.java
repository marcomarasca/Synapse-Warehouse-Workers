package org.sagebionetworks.warehouse.workers.utils;

import static org.junit.Assert.*;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeUtilsTest {

	@Test
	public void testGetNextMonthSameYear(){
		Date date = new DateTime(2016, 1, 1, 0, 0).toDate();
		assertEquals(new DateTime(2016, 2, 1, 0, 0).toDate(), DateTimeUtils.getNextMonth(date));
	}

	@Test
	public void testGetNextMonthDifferentYear(){
		Date date = new DateTime(2015, 12, 1, 0, 0).toDate();
		assertEquals(new DateTime(2016, 1, 1, 0, 0).toDate(), DateTimeUtils.getNextMonth(date));
	}

	@Test
	public void testToDateString(){
		Date date = new DateTime(2016, 1, 14, 0, 0).toDate();
		assertEquals("2016-01-14", DateTimeUtils.toDateString(date));
	}
}
