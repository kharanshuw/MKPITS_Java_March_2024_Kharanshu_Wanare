/*
1. **Calculate Late Fees for a Rental**:
   Write a function that accepts a rental ID and calculates the total late fees incurred for that rental. The function should return the total late fee amount based on the difference between the return date and the due date.
*/
DELIMITER //
CREATE FUNCTION Get_Film_Rating_by_Title(var1 number(22))
   RETURNS number(5,2)
   DETERMINISTIC
   BEGIN
      declare total_amount number(5,2);
      select p.rental_id,sum(amount) into total_amount from rental r 
	  join payment p 
	  on p.rental_id=r.rental_id 
	  where p.rental_id=var1
	  GROUP by p.rental_id; 
	  return total_amount;
   END//
DELIMITER ;


/*
2. **Get Film Rating by Title**:
   Create a function that takes a film title as input and returns the film's rating. The function should search for the film by title and return its rating (e.g., G, PG, PG-13, R, NC-17).

*/

DELIMITER //
CREATE FUNCTION Get_Film_Rating_by_Title(var1 VARCHAR(128))
   RETURNS enum('G','PG','PG-13','R','NC-17')
   DETERMINISTIC
   BEGIN
      declare r_rating enum('G','PG','PG-13','R','NC-17');
      select rating into r_rating from Film where film_id=var1; 
	  return r_rating;
   END//
DELIMITER ;


select Get_Film_Rating_by_Title('ALICE FANTASIA');


/*
3. **Count Films by Language**:
   Develop a function that accepts a language name and returns the number of films available in that language. The function should query the films and languages tables to provide the count.
*/


DELIMITER //
CREATE FUNCTION Count_Films_by_Language(var1 VARCHAR(128))
   RETURNS INTEGER
   DETERMINISTIC
   BEGIN
   declare count_film INTEGER;
	   select Count(f.film_id) into count_film
		from  language l 
		join film f 
		on f.language_id=l.language_id
		where l.name=var1
		GROUP by f.language_id;
	return count_film;
   END//
DELIMITER ;

select Count_Films_by_Language('english')

/*4. **Check Film Availability**:
   Implement a function that takes a film ID as input and returns a Boolean value indicating whether the film is currently available for rent. The function should check the inventory and rental tables to determine availability.
*/
DELIMITER //
CREATE FUNCTION is_film_available(film_id INT)
RETURNS BOOLEAN
BEGIN
  DECLARE available BOOLEAN DEFAULT FALSE;

  SELECT CASE WHEN (i.quantity > 0 ) THEN TRUE ELSE FALSE END AS is_available
  FROM inventory i
  LEFT JOIN rental r ON i.film_id = r.film_id AND r.return_date IS NULL
  WHERE i.film_id = film_id
  INTO available;

  RETURN available;
END //

DELIMITER ;

/*
5. **Get Customer Rental History**:
   Write a function that accepts a customer ID and returns the total number of rentals made by that customer. The function should aggregate the rentals based on the provided customer ID and return the count.
*/

DELIMITER //
CREATE FUNCTION count_of_rental(c_id INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN

	declare count_of_rental INTEGER DEFAULT 0;
	select Count(r.rental_id)  INTO count_of_rental
	from customer c 
	join rental r 
	on r.customer_id=c.customer_id
	where r.customer_id=c_id
	GROUP by r.customer_id
	
	
  RETURN count_of_rental;
END //

DELIMITER ;



select count_of_rental(33)