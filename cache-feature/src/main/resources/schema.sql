DROP TABLE BOOK IF EXISTS;

CREATE TABLE BOOK(
    ID INT PRIMARY KEY,
    ISBN VARCHAR(250) NOT NULL,
    TITLE VARCHAR(250) NOT NULL
);