CREATE TABLE IF NOT EXISTS `TEAM_MEMBER_SNAPSHOT` (
  `TIMESTAMP` bigint NOT NULL,
  `TEAM_ID` bigint(20) NOT NULL,
  `MEMBER_ID` bigint(20) NOT NULL,
  `IS_ADMIN` boolean DEFAULT NULL,
  PRIMARY KEY (`TIMESTAMP`, `TEAM_ID`, `MEMBER_ID`)
)
