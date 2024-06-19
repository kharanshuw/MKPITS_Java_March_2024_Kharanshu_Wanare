/*Create following tables and insert data 
Account - Account_No, Name, Address, City, Balance 
Transactions - Account_No, Amount, Transaction_Type, Date*/
CREATE TABLE Account (
    Account_No INT PRIMARY KEY,
    Name VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50),
    Balance DECIMAL(10, 2)
);

ALTER TABLE Account
ALTER City set DEFAULT 'nagpur'

ALTER TABLE Account
ADD CONSTRAINT ch_bal CHECK(Balance>=0); 



CREATE TABLE Transactions (
    Transaction_ID INT PRIMARY KEY AUTO_INCREMENT,
    Account_No INT,
    Amount DECIMAL(10, 2),
    Transaction_Type VARCHAR(20),
    Date DATE,
    FOREIGN KEY (Account_No) REFERENCES Account(Account_No)
);

ALTER TABLE transactions
AUTO_INCREMENT=100;

ALTER TABLE transactions 
ADD CONSTRAINT ch_amount CHECK(Amount>0);

ALTER TABLE transactions
ADD CONSTRAINT ch_type Check (Transaction_Type in ('Deposit', 'Withdrawal'))

ALTER TABLE transactions
ALTER date set DEFAULT CURRENT_DATE();


INSERT INTO Account (Account_No, Name, Address, City, Balance)
VALUES
    (1, 'John Doe', '123 Main St', 'New York', 1000.00),
    (2, 'Jane Smith', '456 Elm St', 'Los Angeles', 2000.00),
    (3, 'Michael Johnson', '789 Oak St', 'Chicago', 1500.00);

INSERT INTO Transactions (Account_No, Amount, Transaction_Type, Date)
VALUES
    (1, 500.00, 'Deposit', '2023-06-16'),
    (1, -200.00, 'Withdrawal', '2023-06-15'),
    (2, 300.00, 'Deposit', '2023-06-14'),
    (3, -100.00, 'Withdrawal', '2023-06-13'),
    (1, 150.00, 'Deposit', '2023-06-12'),
    (2, -250.00, 'Withdrawal', '2023-06-11');
	


/*1.Retrieve the names and addresses of all account holders in ’New York’*/
SELECT Name, Address
FROM Account
WHERE City = 'New York';


/*2.Find the total balance of all accounts. */
SELECT Account_No,SUM(Balance) AS Total_Balance
FROM Account
GROUP by Account_No;

/*3.List all transactions of account number ’12345’ sorted by date in descending 
order*/
SELECT *
FROM Transactions
WHERE Account_No = 12345
ORDER BY Date DESC;


/*4.Find the names of account holders who have made a transaction greater than 
$500.*/
SELECT DISTINCT a.Name
FROM Account a
JOIN Transactions t ON a.Account_No = t.Account_No
WHERE t.Amount > 500;

/*5.Retrieve the account number and balance of the account with the highest 
balance. */
SELECT Account_No, Balance
FROM Account
ORDER BY Balance DESC
LIMIT 1;


/*6.Find the average transaction amount for ’Debit’ transactions. */
SELECT AVG(Amount)
FROM Transactions
WHERE Transaction_Type = 'Debit';


/*7. List the account numbers that have not made any transactions.*/
SELECT a.Account_No
FROM Account a
JOIN Transactions t ON a.Account_No = t.Account_No
WHERE t.Transaction_ID IS NULL;


/*8.Retrieve the total number of transactions made in the month of  May 2024.*/
SELECT COUNT(*) AS Total_Transactions_May_2024
FROM Transactions
WHERE YEAR(Date) = 2024 AND MONTH(Date) = 5;


/*9.Find the balance of the account with account number ’56789’.*/
SELECT Balance 
FROM Account
WHERE Account_No=56789

/*10.List the names and total transaction amounts of account holders who have made 
transactions totaling more than $1000. */
SELECT a.name,SUM(t.Amount)
FROM Account a 
JOIN transactions t 
ON t.Account_No=a.Account_No
GROUP by a.Account_No
HAVING SUM(t.Amount) > 1000;
