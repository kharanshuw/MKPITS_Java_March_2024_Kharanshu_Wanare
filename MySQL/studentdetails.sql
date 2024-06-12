create table studentdetails(
rollno char(4),
studentname char(10),
address varchar(25),
city char(10)
);

desc sakila.studentdetails;

insert into studentdetails VALUES('1001','pratik','hingna','nagpur');
INSERT INTO studentdetails VALUES
('1004', 'Shreya', 'Aundh', 'Pune'),
('1005', 'Rohan', 'Kandivali', 'Mumbai'),
('1006', 'Aditi', 'Koramangala', 'Bangalore'),
('1010', 'Your Name', 'Your Address', 'Your City'); 

just like above add 10 new RECORD by using same syntex like given
*************
create table studentrecord(
markdetails INTEGER,
rollno INTEGER,
phy INTEGER,
chemistry INTEGER,
marks INTEGER
);

SELECT * FROM studentrecord

insert into studentrecord VALUES(250,1001,40,50,60);
INSERT INTO studentrecord VALUES
(251, 1002, 55, 60, 70),  -- New student with different marks
(252, 1003, 75, 80, 90); 
INSERT INTO studentdetails VALUES
(260, 1011, 65, 70, 80),
(261, 1012, 80, 85, 90),
(262, 1013, 78, 82, 95),
(263, 1014, 50, 65, 72),
(264, 1015, 90, 95, 100),
(265, 1016, 42, 58, 69),
(266, 1017, 75, 88, 92),
(267, 1018, 60, 73, 84),
(268, 1019, 85, 92, 98),
(269, 1020, 38, 51, 66);



database shop mangagement

tables Name
1 product
2 customer
3 suppliar
4 sales 
5 purchase