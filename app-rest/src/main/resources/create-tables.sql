DROP TABLE PARKING IF EXISTS;
CREATE TABLE PARKING (
    parkingid INTEGER PRIMARY KEY NOT NULL,
    amountplace INTEGER NOT NULL,
    address VARCHAR(255) NOT NULL
);