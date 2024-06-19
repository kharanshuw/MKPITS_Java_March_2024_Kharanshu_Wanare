/*Create following Tables insert data
Customer - Customer_Id, Name, Address, City
Supplier - Supplier_Id, Name, Address, City
ProductMaster - Product_Id, Name, Price, QOH
Sale - Sale_Id, Product_id, Customer_id, Quantity, Date
Purchase - Purchase_Id, Product_id, Customer_id, Quantity, Date*/

Create DATABASE SalesDatabase

use SalesDatabase

-- Create the Customer table
CREATE TABLE Customer (
    Customer_Id INT PRIMARY KEY,
    Name VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50)
);

-- Create the Supplier table
CREATE TABLE Supplier (
    Supplier_Id INT PRIMARY KEY,
    Name VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50)
);

-- Create the ProductMaster table
CREATE TABLE ProductMaster (
    Product_Id INT PRIMARY KEY,
    Name VARCHAR(100),
    Price DECIMAL(10, 2),
    QOH INT
);

-- Create the Sale table
CREATE TABLE Sale (
    Sale_Id INT PRIMARY KEY,
    Product_Id INT,
    Customer_Id INT,
    Quantity INT,
    Date DATE,
    FOREIGN KEY (Product_Id) REFERENCES ProductMaster(Product_Id),
    FOREIGN KEY (Customer_Id) REFERENCES Customer(Customer_Id)
);

-- Create the Purchase table
CREATE TABLE Purchase (
    Purchase_Id INT PRIMARY KEY,
    Product_Id INT,
    Supplier_Id INT,
    Quantity INT,
    Date DATE,
    FOREIGN KEY (Product_Id) REFERENCES ProductMaster(Product_Id),
    FOREIGN KEY (Supplier_Id) REFERENCES Supplier(Supplier_Id)
);

-- Insert data into Customer table
INSERT INTO Customer (Customer_Id, Name, Address, City)
VALUES
    (1, 'John Doe', '123 Main St', 'New York'),
    (2, 'Jane Smith', '456 Elm St', 'Los Angeles'),
    (3, 'Michael Johnson', '789 Oak St', 'Chicago');

-- Insert data into Supplier table
INSERT INTO Supplier (Supplier_Id, Name, Address, City)
VALUES
    (1, 'ABC Suppliers', '555 Supplier St', 'Houston'),
    (2, 'XYZ Distributors', '987 Distributor Ave', 'Miami');

-- Insert data into ProductMaster table
INSERT INTO ProductMaster (Product_Id, Name, Price, QOH)
VALUES
    (1, 'Product A', 25.99, 50),
    (2, 'Product B', 15.75, 30),
    (3, 'Product C', 10.50, 20);

-- Insert data into Sale table
INSERT INTO Sale (Sale_Id, Product_Id, Customer_Id, Quantity, Date)
VALUES
    (1, 1, 1, 2, '2023-06-16'),
    (2, 2, 2, 1, '2023-06-15'),
    (3, 3, 3, 3, '2023-06-14');

-- Insert data into Purchase table
INSERT INTO Purchase (Purchase_Id, Product_Id, Supplier_Id, Quantity, Date)
VALUES
    (1, 1, 1, 10, '2023-06-13'),
    (2, 2, 2, 5, '2023-06-12'),
    (3, 3, 1, 20, '2023-06-11');

/*1.Retrieve the names and addresses of all suppliers in 'Los Angeles'.*/
SELECT s.Name,s.Address
FROM Supplier s 
WHERE s.City="Los Angeles";

/*2.Find the total quantity of products sold.
*/
SELECT SUM(Quantity) AS Total_Quantity_Sold
FROM Sale;

/*3.List all purchases of product ID 'P001' sorted by date in ascending order*/
SELECT *
FROM Purchase
WHERE Product_Id = 'P001'
ORDER BY Date ASC;

/*4.Find the names of products that have been sold more than 100 times*/
SELECT pm.Name,COUNT(s.Quantity)
FROM ProductMaster pm
join sale s on s.Product_Id=pm.Product_id
GROUP by pm.Product_Id
HAVING COUNT(s.quantity)>100


/*5. Retrieve the product ID and name of the product with the highest price.
*/
SELECT p.Product_id,p.Name
FROM ProductMaster p 
ORDER by Price DESC
LIMIT 1;

/*6. Find the average price of products in the product master.*/
SELECT AVG(p.Price) 
FROM ProductMaster p


/*7. List the product IDs that have not been sold.*/
SELECT p.Product_id 
FROM ProductMaster p 
WHERE p.Product_id NOT IN (SELECT DISTINCT s.Product_id FROM sale s);

/*8.Retrieve the total number of sales made in the month of June 2024.*/
SELECT COUNT(s.Sale_Id) FROM sale
WHERE YEAR(Date) in (2024 ) and month(Date) in (6);

/*9.Find the quantity on hand (QOH) of the product with product ID 'P005'.*/
SELECT p.QOH
FROM ProductMaster p
WHERE QOH=p005;

/*10.List the names and total quantities purchased of products that have been purchased more than 200 times.*/
select p.name,sum(pr.quantity) from purchase pr join
productmaster p on pr.product_id=p.product_id  
group by p.name 
having count(pr.product_id)>200;
select * from purchase;