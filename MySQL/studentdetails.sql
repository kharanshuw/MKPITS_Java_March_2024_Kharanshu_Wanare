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
*************
create table student_marks (
markdetails INTEGER,
rollno INTEGER,
phy INTEGER,
chemistry INTEGER,
marks INTEGER
);

INSERT INTO student_marks (markdetails, rollno, phy, chemistry, marks)
VALUES (1, 101, 75, 68, 143),
       (2, 102, 80, 72, 152),
       (3, 103, 90, 85, 175),
       (4, 104, 85, 79, 164),
       (5, 105, 78, 82, 160),
       -- Duplicate record with rollno 102
       (4, 102, 83, 75, 158), 
       (6, 106, 82, 88, 170),
       (7, 107, 95, 92, 187),
       (8, 108, 70, 75, 145),
       -- Duplicate record with markdetails 2
       (2, 109, 85, 78, 163);


