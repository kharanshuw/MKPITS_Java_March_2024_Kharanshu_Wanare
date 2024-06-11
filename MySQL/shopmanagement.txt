CREATE TABLE Supplier (
    supplierid INT ,
    suppliername VARCHAR(100),
    contactname VARCHAR(50),
	supplieraddress varchar(50)
);

CREATE TABLE Product (
    productid INT ,
    productname VARCHAR(100),
    supplierid INT,
    unitprice DECIMAL(10, 2),
);

CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    contact_name VARCHAR(50),
    contact_email VARCHAR(100),
    phone_number VARCHAR(20)
);


CREATE TABLE Sales (
    saleid INT ,
    saledate DATE,
    customer_id INT,
    total_amount DECIMAL(12, 2),
);

CREATE TABLE Purchase (
    purchase_id INT ,
    purchase_date DATE,
    supplier_id INT,
    total_amount DECIMAL(12, 2),
    productid int;
);