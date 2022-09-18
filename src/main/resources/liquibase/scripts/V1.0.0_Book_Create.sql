BEGIN
TRANSACTION;

CREATE TABLE BOOK
(
    ID                        NUMBER(10)                AUTO_INCREMENT,
    TITLE                     VARCHAR2(100)             NOT NULL,
    NUMBER_OF_PAGES           NUMBER(20)                NOT NULL
);

ALTER TABLE BOOK
    ADD CONSTRAINT PK_BOOK PRIMARY KEY (ID);
ALTER TABLE BOOK
    ADD CONSTRAINT UNIQUE_TITLE UNIQUE (TITLE);

COMMENT ON TABLE BOOK IS 'Table of books';
COMMENT ON COLUMN BOOK.ID IS 'Book identifier';
COMMENT ON COLUMN BOOK.TITLE IS 'Book title ';
COMMENT ON COLUMN BOOK.NUMBER_OF_PAGES IS 'Number of pages';

COMMIT;
