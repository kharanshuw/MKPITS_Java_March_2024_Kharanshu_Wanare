--Aggregate Functions in MySQL
The ISO standard defines five (5) aggregate functions namely;

1) COUNT
2) SUM
3) AVG
4) MIN
5) MAX

--The COUNT function returns the total number of values in the specified field. It works on both numeric and non-numeric data types. All aggregate functions by default exclude nulls values before working on the data.

--COUNT (*) is a special implementation of the COUNT function that returns the count of all the rows in a specified table. COUNT (*) also considers Nulls and duplicates.
SELECT COUNT(*) FROM studentdetails

SELECT COUNT (DISTINCT rollno) from studentdetails

/*
SUM function which returns the sum of all the values in the specified column. SUM works on numeric fields only. Null values are excluded from the result returned.
*/
SELECT SUM(rollno) FROM studentdetails

/*
the MAX function is the opposite of the MIN function. It returns the largest value from the specified table field
*/
SELECT MAX(rollno) FROM studentdetails
/*The MIN function returns the smallest value in the specified table field.*/
SELECT MIN(rollno) from studentdetails
/*MySQL AVG function returns the average of the values in a specified column. Just like the SUM function, it works only on numeric data types.*/
SELECT AVG(rollno) from studentdetails