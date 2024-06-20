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


