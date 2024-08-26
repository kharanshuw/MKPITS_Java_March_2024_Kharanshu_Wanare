CREATE TABLE accountholdermaster (
    userid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    accno INT,
    amount DECIMAL(10, 2) NOT NULL,
    transaction_type varchar(30) NOT NULL,
	CONSTRAINT FK_accno
    FOREIGN KEY (accno) REFERENCES accountholdermaster(userid)
);

