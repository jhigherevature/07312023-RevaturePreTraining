-- Zero Normal Form (0NF) : Unstructured
CREATE TABLE LibraryRecords_0NF (
    RecordID INT,
    TitleAndAuthors VARCHAR,
    PublicationDates VARCHAR,
    Genres VARCHAR
);

-- First Normal Form (1NF): Atomic Data, Identifying Column
CREATE TABLE LibraryRecords_1NF (
    RecordID INT PRIMARY KEY,
    Title VARCHAR(200),
    Author VARCHAR(200),
    PublicationDate DATE,
    Genre VARCHAR(200)
);

-- Second Normal Form (2NF) : All qualities of 1NF but also NO partial dependencies 
-- 		(all data functionally related to PK)
CREATE TABLE Authors_2NF (
    AuthorID INT PRIMARY KEY,
    AuthorName TEXT
);

CREATE TABLE LibraryRecords_2NF (
    RecordID INT PRIMARY KEY,
    Title VARCHAR(200),
    AuthorID VARCHAR(200),
    PublicationDate DATE,
    Genre VARCHAR(200),
    FOREIGN KEY (AuthorID) REFERENCES Authors_2NF(AuthorID)
);

-- Third Normal Form (3NF) : All qualities of 2NF but also, no transitive dependencies 
CREATE TABLE Authors_3NF (
    AuthorID INT PRIMARY KEY,
    AuthorName VARCHAR(200)
);

CREATE TABLE Genres_3NF (
    GenreID INT PRIMARY KEY,
    GenreName VARCHAR(200)
);

CREATE TABLE LibraryRecords_3NF (
    RecordID INT PRIMARY KEY,
    Title VARCHAR(200),
    AuthorID INT,
    PublicationDate DATE,
    GenreID INT,
    FOREIGN KEY (AuthorID) REFERENCES Authors_3NF(AuthorID),
    FOREIGN KEY (GenreID) REFERENCES Genres_3NF(GenreID)
);
