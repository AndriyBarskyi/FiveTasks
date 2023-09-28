CREATE TABLE IF NOT EXISTS Suppliers
(
    SupplierID   SERIAL PRIMARY KEY,
    SupplierName varchar(255) NOT NULL,
    City         varchar(255) NOT NULL,
    Country      varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Categories
(
    CategoryID   SERIAL PRIMARY KEY,
    CategoryName varchar(255) NOT NULL,
    Description  text         NOT NULL
);

CREATE TABLE IF NOT EXISTS Products
(
    ProductID   SERIAL PRIMARY KEY,
    ProductName varchar(255) NOT NULL,
    SupplierID  integer REFERENCES Suppliers (SupplierID),
    CategoryID  integer REFERENCES Categories (CategoryID),
    Price       money        NOT NULL
);
