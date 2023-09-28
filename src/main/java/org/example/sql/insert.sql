INSERT INTO Suppliers (SupplierName, City, Country)
VALUES ('Exotic Liquid', 'London', 'UK'),
       ('New Orleans Cajun Delights', 'New Orleans', 'USA'),
       ('Grandma Kelly’s Homestead', 'Ann Arbor', 'USA'),
       ('Tokyo Traders', 'Tokyo', 'Japan'),
       ('Cooperativa de Quesos ‘Las Cabras’', 'Oviedo', 'Spain');

INSERT INTO Categories (CategoryName, Description)
VALUES ('Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
       ('Condiments',
        'Sweet and savory sauces, relishes, spreads, and seasonings'),
       ('Confections', 'Desserts, candies, and sweet breads'),
       ('Dairy Products', 'Cheeses'),
       ('Grains/Cereals', 'Breads, crackers, pasta, and cereal');

INSERT INTO Products (ProductName, SupplierID, CategoryID, Price)
VALUES ('Chais', 1, 1, 18.00),
       ('Chang', 1, 1, 19.00),
       ('Aniseed Syrup', 1, 2, 10.00),
       ('Chef Anton’s Cajun Seasoning', 2, 2, 22.00),
       ('Chef Anton’s Gumbo Mix', 2, 2, 21.35);