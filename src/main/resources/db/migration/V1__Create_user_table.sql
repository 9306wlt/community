create table USER
(
	ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	ACCOUNT_ID VARCHAR(100),
	NAME VARCHAR(100),
	TOKEN CHAR(36),
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
);




