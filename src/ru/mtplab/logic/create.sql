CREATE TABLE IF NOT EXISTS USERS
(
    ID          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    LOGIN       TEXT    UNIQUE      NOT NULL,
    PASSWORD    CHAR(32)
);

CREATE TABLE IF NOT EXISTS ACCOUNTS
(
    ID          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    DESCR       TEXT                NOT NULL,
    USER_NAME   TEXT                NOT NULL
);

CREATE TABLE IF NOT EXISTS RECORDS
(
    ID          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    DESCR       TEXT                NOT NULL,
    AMOUNT      REAL                NOT NULL,
    CATEGORY_ID INT                 NOT NULL,
    ACCOUNT_ID  INT                 NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORIES
(
    ID          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    NAME        TEXT                NOT NULL
);