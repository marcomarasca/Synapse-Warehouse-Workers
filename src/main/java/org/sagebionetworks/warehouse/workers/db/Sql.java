package org.sagebionetworks.warehouse.workers.db;

/**
 * SQL constants.
 *
 */
public class Sql {

	// FILE_STATE
	public static final String TABLE_FILE_STATE = 				"FILE_STATE";
	public static final String COL_FILE_STATE_BUCKET = 			"S3_BUCKET";
	public static final String COL_FILE_STATE_KEY = 			"S3_KEY";
	public static final String COL_FILE_STATE_STATE = 			"STATE";
	public static final String COL_FILE_STATE_UPDATED_ON = 		"UPDATED_ON";
	public static final String COL_FILE_STATE_ERROR = 			"ERROR_MESSAGE";
	public static final String COL_FILE_STATE_ERROR_DETAILS = 	"ERROR_DETAILS";

	// FOLDER_STATE
	public static final String TABLE_FOLDER_STATE = 			"FOLDER_STATE";
	public static final String COL_FOLDER_STATE_BUCKET = 		"S3_BUCKET";
	public static final String COL_FOLDER_STATE_PATH = 			"S3_PATH";
	public static final String COL_FOLDER_STATE_STATE = 		"STATE";
	public static final String COL_FOLDER_STATE_UPDATED_ON = 	"UPDATED_ON";

	// PROCESSED_ACCESS_RECORD
	public static final String TABLE_PROCESSED_ACCESS_RECORD = 								"PROCESSED_ACCESS_RECORD";
	public static final String COL_PROCESSED_ACCESS_RECORD_SESSION_ID = 					"SESSION_ID";
	public static final String COL_PROCESSED_ACCESS_RECORD_ENTITY_ID = 						"ENTITY_ID";
	public static final String COL_PROCESSED_ACCESS_RECORD_CLIENT = 						"CLIENT";
	public static final String COL_PROCESSED_ACCESS_RECORD_NORMALIZED_METHOD_SIGNATURE = 	"NORMALIZED_METHOD_SIGNATURE";

	// ACCESS_RECORD
	public static final String TABLE_ACCESS_RECORD = 					"ACCESS_RECORD";
	public static final String COL_ACCESS_RECORD_SESSION_ID = 			"SESSION_ID";
	public static final String COL_ACCESS_RECORD_RETURN_OBJECT_ID = 	"RETURN_OBJECT_ID";
	public static final String COL_ACCESS_RECORD_ELAPSE_MS = 			"ELAPSE_MS";
	public static final String COL_ACCESS_RECORD_TIMESTAMP = 			"TIMESTAMP";
	public static final String COL_ACCESS_RECORD_VIA = 					"VIA";
	public static final String COL_ACCESS_RECORD_HOST = 				"HOST";
	public static final String COL_ACCESS_RECORD_THREAD_ID = 			"THREAD_ID";
	public static final String COL_ACCESS_RECORD_USER_AGENT = 			"USER_AGENT";
	public static final String COL_ACCESS_RECORD_QUERY_STRING = 		"QUERY_STRING";
	public static final String COL_ACCESS_RECORD_X_FORWARDED_FOR = 		"X_FORWARDED_FOR";
	public static final String COL_ACCESS_RECORD_REQUEST_URL = 			"REQUEST_URL";
	public static final String COL_ACCESS_RECORD_USER_ID = 				"USER_ID";
	public static final String COL_ACCESS_RECORD_ORIGIN = 				"ORIGIN";
	public static final String COL_ACCESS_RECORD_DATE = 				"DATE";
	public static final String COL_ACCESS_RECORD_METHOD = 				"METHOD";
	public static final String COL_ACCESS_RECORD_VM_ID = 				"VM_ID";
	public static final String COL_ACCESS_RECORD_INSTANCE = 			"INSTANCE";
	public static final String COL_ACCESS_RECORD_STACK = 				"STACK";
	public static final String COL_ACCESS_RECORD_SUCCESS = 				"SUCCESS";
	public static final String COL_ACCESS_RECORD_RESPONSE_STATUS = 		"RESPONSE_STATUS";

	// NODE_SNAPSHOT
	public static final String TABLE_NODE_SNAPSHOT = 				"NODE_SNAPSHOT";
	public static final String COL_NODE_SNAPSHOT_TIMESTAMP = 		"TIMESTAMP";
	public static final String COL_NODE_SNAPSHOT_ID = 				"ID";
	public static final String COL_NODE_SNAPSHOT_BENEFACTOR_ID = 	"BENEFACTOR_ID";
	public static final String COL_NODE_SNAPSHOT_PROJECT_ID = 		"PROJECT_ID";
	public static final String COL_NODE_SNAPSHOT_PARENT_ID = 		"PARENT_ID";
	public static final String COL_NODE_SNAPSHOT_NODE_TYPE = 		"NODE_TYPE";
	public static final String COL_NODE_SNAPSHOT_CREATED_ON = 		"CREATED_ON";
	public static final String COL_NODE_SNAPSHOT_CREATED_BY = 		"CREATED_BY";
	public static final String COL_NODE_SNAPSHOT_MODIFIED_ON = 		"MODIFIED_ON";
	public static final String COL_NODE_SNAPSHOT_MODIFIED_BY = 		"MODIFIED_BY";
	public static final String COL_NODE_SNAPSHOT_VERSION_NUMBER = 	"VERSION_NUMBER";
	public static final String COL_NODE_SNAPSHOT_FILE_HANDLE_ID = 	"FILE_HANDLE_ID";
	public static final String COL_NODE_SNAPSHOT_NAME = 			"NAME";

	// TEAM_SNAPSHOT
	public static final String TABLE_TEAM_SNAPSHOT =					"TEAM_SNAPSHOT";
	public static final String COL_TEAM_SNAPSHOT_TIMESTAMP = 			"TIMESTAMP";
	public static final String COL_TEAM_SNAPSHOT_ID = 					"ID";
	public static final String COL_TEAM_SNAPSHOT_CREATED_ON = 			"CREATED_ON";
	public static final String COL_TEAM_SNAPSHOT_CREATED_BY = 			"CREATED_BY";
	public static final String COL_TEAM_SNAPSHOT_MODIFIED_ON = 			"MODIFIED_ON";
	public static final String COL_TEAM_SNAPSHOT_MODIFIED_BY = 			"MODIFIED_BY";
	public static final String COL_TEAM_SNAPSHOT_NAME = 				"NAME";
	public static final String COL_TEAM_SNAPSHOT_CAN_PUBLIC_JOIN = 		"CAN_PUBLIC_JOIN";

	// TEAM_MEMBER_SNAPSHOT
	public static final String TABLE_TEAM_MEMBER_SNAPSHOT =				"TEAM_MEMBER_SNAPSHOT";
	public static final String COL_TEAM_MEMBER_SNAPSHOT_TIMESTAMP = 	"TIMESTAMP";
	public static final String COL_TEAM_MEMBER_SNAPSHOT_TEAM_ID = 		"TEAM_ID";
	public static final String COL_TEAM_MEMBER_SNAPSHOT_MEMBER_ID = 	"MEMBER_ID";
	public static final String COL_TEAM_MEMBER_SNAPSHOT_IS_ADMIN = 		"IS_ADMIN";

	// USER_PROFILE_SNAPSHOT
	public static final String TABLE_USER_PROFILE_SNAPSHOT = 			"USER_PROFILE_SNAPSHOT";
	public static final String COL_USER_PROFILE_SNAPSHOT_TIMESTAMP = 	"TIMESTAMP";
	public static final String COL_USER_PROFILE_SNAPSHOT_ID = 			"ID";
	public static final String COL_USER_PROFILE_SNAPSHOT_USER_NAME = 	"USER_NAME";
	public static final String COL_USER_PROFILE_SNAPSHOT_FIRST_NAME = 	"FIRST_NAME";
	public static final String COL_USER_PROFILE_SNAPSHOT_LAST_NAME = 	"LAST_NAME";
	public static final String COL_USER_PROFILE_SNAPSHOT_EMAIL = 		"EMAIL";
	public static final String COL_USER_PROFILE_SNAPSHOT_LOCATION = 	"LOCATION";
	public static final String COL_USER_PROFILE_SNAPSHOT_COMPANY = 		"COMPANY";
	public static final String COL_USER_PROFILE_SNAPSHOT_POSITION = 	"POSITION";
}
