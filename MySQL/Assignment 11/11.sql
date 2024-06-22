
CREATE SCHEMA newshop;
use newshop;
create table Customer(customer_Id int not null,name varchar(20),address varchar(30),city varchar(10),primary key(customer_id));
create table Supplier(supplier_Id varchar(10) not null,name varchar(20),address varchar(30),city varchar(10));
create table ProductMaster(product_Id varchar(10) not null,name varchar(20),price int,qty_on_hand int);
create table Sale(sale_Id varchar(10) not null,product_Id varchar(10) not null,customer_Id int not null,quantity int,sale_date datetime);
create table Purchase(purchase_Id varchar(10),product_Id varchar(10),customer_Id int,quantity int,purchase_date datetime);
show tables;

insert into productmaster values('p001','nirma',20.0,100);
insert into productmaster values('p002','lux',35.0,50);
insert into productmaster values('p003','sweet cake',20.0,100);
insert into productmaster values('p004','parle biscuit',10.0,150);
insert into productmaster values('p005','cadbury',20.0,200);
insert into productmaster values('p006','pepsi',25.0,80);

insert into supplier values('S001','abc supplier','new ca road','los angels');
insert into supplier values('S002','la wholesale','sunset blvd','los angels');

insert into sale values('sa001','p001',1,30,curdate());
insert into sale values('sa002','p002',2,20,curdate());
insert into sale values('sa003','p003',3,10,curdate());
insert into sale values('sa004','p004',4,5,curdate());
insert into sale values('sa005','p004',4,10,curdate());
select * from sale;

insert into purchase values('1001','p001',1,30,curdate());
insert into purchase values('1002','p002',2,20,curdate());
insert into purchase values('1003','p003',3,10,curdate());
insert into purchase values('1004','p004',4,10,curdate());
insert into purchase values('1005','p004',4,5,curdate());
select * from purchase










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