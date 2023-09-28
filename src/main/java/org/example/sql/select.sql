-- Select product with product name that begins with ‘C’
SELECT *
FROM Products
WHERE ProductName LIKE 'C%';

-- Select product with the smallest price.
SELECT *
FROM Products
WHERE Price = (SELECT MIN(Price) FROM Products);

-- Select cost of all products from the USA.
SELECT SUM(Price) AS TotalCost
FROM Products
         INNER JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
WHERE Suppliers.Country = 'USA';

-- Select suppliers that supply Condiments.
SELECT Suppliers.SupplierName
FROM Suppliers
         INNER JOIN Products ON Suppliers.SupplierID = Products.SupplierID
         INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID
WHERE Categories.CategoryName = 'Condiments';

-- Add to database new supplier with name: ‘Norske Meierier’, city: ‘Lviv’, country: ‘Ukraine’ which
-- will supply new product with name: ‘Green tea’, price: 10, and related to category with name:
-- ‘Beverages’.
INSERT INTO Suppliers (SupplierName, City, Country)
VALUES ('Norske Meierier', 'Lviv', 'Ukraine');

SELECT *
FROM Suppliers
WHERE SupplierName = 'Norske Meierier'
  AND City = 'Lviv'
  AND Country = 'Ukraine';

INSERT INTO Products (ProductName, SupplierID, CategoryID, Price)
VALUES ('Green tea', (SELECT SupplierID
                      FROM Suppliers
                      WHERE SupplierName = 'Norske Meierier'
                        AND City = 'Lviv'
                        AND Country = 'Ukraine'),
        (SELECT CategoryID FROM Categories WHERE CategoryName = 'Beverages'),
        10.00);

SELECT *
FROM Products
WHERE ProductName = 'Green tea';