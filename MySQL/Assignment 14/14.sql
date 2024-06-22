/*
1. **Retrieve Actor Information by Last Name**:
   Write a procedure that accepts an actor's last name as input and returns a list of all actors with that last name, including their first name, last name, and actor ID.
*/

delimiter --

CREATE procedure  ActorInformation (IN l_name VARCHAR(50))
BEGIN 
SELECT first_name,last_name,actor_id
FROM actor a 
WHERE last_name=l_name;
end --
delimiter ;

 call ActorInformation('WAHLBERG');


/*2. **List Films by Category**:
   Create a procedure that takes a category name as input and returns all films in that category, including film title, description, release year, and rating.
*/
delimiter --

CREATE PROCEDURE FilmsByCategory(IN c_name VARCHAR(50))  
BEGIN

  SELECT f.title, f.description, f.release_year, f.rating
  FROM category c
  JOIN film_category fc ON fc.category_id = c.category_id
  JOIN film f ON f.film_id = fc.film_id
  WHERE c.name = c_name; 
END --

delimiter ; 


/*3. **Calculate Total Payment by Customer**:
   Develop a procedure that accepts a customer ID and returns the total amount paid by that customer. The result should include the customer ID, first name, last name, and total payment amount.
*/

delimiter --

CREATE PROCEDURE TotalPayment(IN c_id INTEGER)  
BEGIN

SELECT 
    (c.customer_id),
    c.first_name,
    c.last_name,
    SUM(p.amount)
FROM
    customer c
        JOIN
    Payment p ON p.customer_id = c.customer_id
WHERE
    c.customer_id = c_id
GROUP BY c.customer_id;

end --

delimiter ;

/*4. **Count Rentals by Date Range**:
   Implement a procedure that accepts a start date and an end date and returns the number of rentals made within that date range. Include the rental ID and rental date in the results.
*/


delimiter --

CREATE procedure  DateRange (IN var1 Date,in var2 Date)
BEGIN 
SELECT r.rental_id,r.rental_date
FROM rental r 
WHERE Date(r.rental_date)>Date(var1) and  Date(r.rental_date)<Date(var2) ;

end --
delimiter ;

call DateRange(Date('2005-06-14'),Date('2006-02-14'));


/*
5. **Update Film Rental Rate**:
   Write a procedure to update the rental rate of a specific film. The procedure should accept the film ID and the new rental rate as inputs and then update the rental rate for that film in the database. Return the film ID, old rental rate, and new rental rate as output.
*/


delimiter --

CREATE procedure newFilmRentalRate  (IN var1 INTEGER,in var2 DECIMAL(4,2),OUT var3 DECIMAL(4,2))
BEGIN 

DECLARE var4 DECIMAL (4,2) DEFAULT 0;

UPDATE Film 
SET 
    rental_rate = var2
WHERE
    film_id = var1;
    
SET var4=var2;

SET var3=var4;
end --
delimiter ;


call newFilmRentalRate(5,3.99,@var3);