BEGIN
TRANSACTION;

INSERT INTO BOOK (ID, TITLE, NUMBER_OF_PAGES)
VALUES
    (1, 'Harry Potter and the Globet of Fire', 300),
    (2, 'I, Robot', 250),
    (3, 'The Hobbit', 400);

COMMIT;