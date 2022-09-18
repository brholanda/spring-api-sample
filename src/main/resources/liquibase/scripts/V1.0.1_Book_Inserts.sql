BEGIN
TRANSACTION;

INSERT INTO BOOK (TITLE, NUMBER_OF_PAGES)
VALUES
    ('Harry Potter and the Globet of Fire', 300),
    ('I, Robot', 250),
    ('The Hobbit', 400);

COMMIT;