DROP TABLE Clothing;
DROP TABLE Brands;
Drop TABLE Users;

CREATE TABLE Clothing
(
    ID INTEGER NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    itemType VARCHAR (40) NOT NULL,
    size VARCHAR (40)NOT NULL,
    colour VARCHAR (40) NOT NULL,
    brandID INTEGER,
    userID INTEGER,
    style VARCHAR (40) NOT NULL
 );

CREATE TABLE Brands
(
    brandID INTEGER NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    brandName VARCHAR (40) NOT NULL,
    reccommended VARCHAR (40)NOT NULL,
    shoppingMall VARCHAR (40) NOT NULL
 
 );

CREATE TABLE Users
(
    userID INTEGER NOT NULL PRIMARY KEY 
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    name VARCHAR (40) NOT NULL,
    surname VARCHAR (40)NOT NULL,
    username VARCHAR (40) NOT NULL,
    password VARCHAR (40) NOT NULL
);
 
ALTER TABLE Clothing
ADD CONSTRAINT fk_UserID
FOREIGN KEY (userID)
references Users (UserID);

ALTER TABLE Clothing
ADD CONSTRAINT fk_brandID
FOREIGN KEY (brandID)
references Brands (brandID);
 
INSERT INTO USERS(username, name, surname, password) VALUES('natalia.luiz', 'natalia', 'luiz', 'pwd');