/*
Problem Statement 1: Retrieve Customer Names and Addresses
Create a cursor to retrieve the names and addresses of all customers from the Sakila database.
*/


DELIMITER $$
CREATE PROCEDURE fetch_customer()
BEGIN
    DECLARE myfirst_name VARCHAR(45);
    DECLARE mylast_name VARCHAR(45);
	Declare myaddress_id INTEGER;
	Declare i INTEGER DEFAULT 1;
	Declare rc INTEGER ;
    DECLARE Customer_cur CURSOR FOR 
	SELECT FIRST_name,LAST_name,address_id from Customer;
    OPEN Customer_cur;
	
	SELECT COUNT(*) into rc from Customer limit 10;
    read_loop: LOOP
        FETCH Customer_cur INTO myfirst_name, mylast_name,myaddress_id;
		
        IF i>=10 THEN
            LEAVE read_loop;
        END IF;
		set i = i+1;
		SELECT myfirst_name,mylast_name,myaddress_id;

    END LOOP;

    -- Close the cursor
    CLOSE Customer_cur;
END$$

DELIMITER ;

call fetch_customer();

DROP PROCEDURE fetch_customer;


/*
Problem Statement 2: Calculate Total Rental Fees for a Customer
Create a cursor to calculate the total rental fees paid by a specific customer in the Sakila database.
*/

DELIMITER $$
CREATE PROCEDURE fetch_amount(in cus_id INTEGER)
BEGIN
    DECLARE mypayment DECIMAL(7,4);
    DECLARE mycustomerid INTEGER;
	Declare i INTEGER DEFAULT 0;
	Declare rc INTEGER ;
    DECLARE amount_cur CURSOR FOR 
	SELECT SUM(p.amount),p.Customer_id 
	from payment p 
	WHERE p.Customer_id=cus_id 
	GROUP by p.Customer_id;
    OPEN amount_cur;
	   
	SELECT COUNT(*) 
	from payment;
	
	WHILE i<0 DO
        
        FETCH amount_cur INTO mypayment,mycustomerid;
		SELECT mypayment,mycustomerid;
    END WHILE;

    CLOSE amount_cur;
END$$

DELIMITER ;

call fetch_amount(4);

DROP PROCEDURE fetch_amount;
/*
Problem Statement 3: Find Overdue Rentals
Create a cursor to identify and display details of rentals that are overdue in the Sakila database.
*/

DELIMITER $$
CREATE PROCEDURE fetch_rental()
BEGIN
    DECLARE myrental_id VARCHAR(20);
    DECLARE myrentaldate VARCHAR(20);
	Declare i INTEGER DEFAULT 0;
	Declare rc INTEGER ;
    DECLARE rental_cur CURSOR FOR 
	SELECT Rental_id,return_date from Rental;
    OPEN rental_cur;
	   
	SELECT COUNT(*) into rc
	from rental;
	
	WHILE i<10 DO
        
        FETCH rental_cur INTO myrental_id,myrentaldate;
		
		SELECT myrental_id,myrentaldate;
    END WHILE;

    CLOSE rental_cur;
END$$

DELIMITER ;

call fetch_rental();

/*
Problem Statement 4: Retrieve Film Information by Category
Create a cursor to retrieve film details for a specific film category from the Sakila database.
*/

DELIMITER $$
CREATE PROCEDURE fetch_Film_information(in c_name VARCHAR(25))
BEGIN
    DECLARE myfilm_id INTEGER;
    DECLARE mytitle VARCHAR(255);
	Declare i INTEGER DEFAULT 0;

    DECLARE film_cur CURSOR FOR 
	SELECT 
    f.film_id, f.title
FROM
    Film f
        JOIN
    film_category fc ON fc.film_id = f.film_id
        JOIN
    category c ON c.category_id = fc.category_id
WHERE
    c.name = c_name;

    OPEN film_cur;
	   
	
	WHILE i<10 DO
        
        FETCH film_cur INTO myfilm_id,mytitle;
		set i = i+1;
		SELECT myfilm_id,mytitle;
    END WHILE;
	
    CLOSE film_cur;
END$$

DELIMITER ;


call fetch_Film_information('Action');

DROP PROCEDURE fetch_Film_information;

/*
Problem Statement 5: Calculate Average Film Rental Duration
Create a cursor to calculate the average rental duration for all films in the Sakila database.
*/

DELIMITER $$

CREATE PROCEDURE fetch_Average_Film_Rental()
BEGIN
    DECLARE myavg INTEGER;

    DECLARE avg_cur CURSOR FOR 
	SELECT AVG(rental_duration)
from Film;
    OPEN avg_cur;
	
        FETCH avg_cur INTO myavg;
		SELECT myavg;
	
    CLOSE avg_cur;
END$$

DELIMITER ;


call fetch_Average_Film_Rental()

DROP PROCEDURE fetch_Average_Film_Rental