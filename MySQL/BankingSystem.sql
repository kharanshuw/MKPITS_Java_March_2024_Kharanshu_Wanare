CREATE DATABASE BankingSystem;
USE BankingSystem;

CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(20)
);

CREATE TABLE SavingsAccounts (
    account_id INT PRIMARY KEY,
    account_type VARCHAR(20),
    balance DECIMAL(12, 2),
    customer_id INT,
   
);

CREATE TABLE CurrentAccounts (
    account_id INT PRIMARY KEY,
    account_type VARCHAR(20),
    balance DECIMAL(12, 2),
    customer_id INT,
    
);

CREATE TABLE Transactions (
    transaction_id INT PRIMARY KEY,
    transaction_type VARCHAR(20),
    amount DECIMAL(12, 2),
    transaction_date DATE,
    account_id INT,
   
);

INSERT INTO Customers (customer_id, first_name, last_name, address, email, phone_number)
VALUES
    (1, 'John', 'Doe', '123 Main St', 'john.doe@example.com', '123-456-7890'),
    (2, 'Jane', 'Smith', '456 Elm St', 'jane.smith@example.com', '987-654-3210'),
	(3, 'Alice', 'Johnson', '789 Oak Ave', 'alice.johnson@example.com', '555-123-4567'),
    (4, 'Bob', 'Williams', '321 Pine St', 'bob.williams@example.com', '555-234-5678'),
    (5, 'Eve', 'Brown', '654 Maple St', 'eve.brown@example.com', '555-345-6789');

INSERT INTO SavingsAccounts (account_id, account_type, balance, customer_id)
VALUES
    (1, 'Savings', 1000.00, 1),
    (2, 'Savings', 5000.00, 2);
	(3, 'Savings', 2000.00, 3),
    (4, 'Savings', 4000.00, 4);

INSERT INTO CurrentAccounts (account_id, account_type, balance, customer_id)
VALUES
    (3, 'Current', 2000.00, 1),
    (4, 'Current', 3000.00, 2);
	(1, 'Current', 3000.00, 5),
    (5, 'Current', 1500.00, 3);

INSERT INTO Transactions (transaction_id, transaction_type, amount, transaction_date, account_id)
VALUES
    (1, 'Deposit', 500.00, '2023-01-01', 1),
    (2, 'Withdrawal', 200.00, '2023-01-05', 1),
    (3, 'Deposit', 1000.00, '2023-01-10', 2),
    (4, 'Transfer', 300.00, '2023-01-15', 2),
    (5, 'Withdrawal', 100.00, '2023-01-20', 3),
    