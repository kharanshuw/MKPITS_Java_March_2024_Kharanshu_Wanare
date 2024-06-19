1. **Retrieve all films with a rental duration of more than 5 days:**
select * from film  where rental_duration>5;



2. **List all customers who live in the city of 'San Diego':**

3. **Find all films with a rating of 'PG-13' and sort them by title:**

select * from film where rating='PG-13' ORDER BY title

4. **Display all actors whose last name starts with 'A' and order by first name:**

SELECT * FROM actor where last_name='%a' order by first_name;

5. **Retrieve all films released in the year 2006:**

SELECT * FROM sakila.film where release_year=2006;

6. **Find all customers whose first name is 'John' and sort by last name in descending order:**

SELECT 
    *
FROM
    sakila.customer
WHERE
    first_name = 'john'
ORDER BY last_name DESC;

7. **List all films with a rental rate between 2.99 and 4.99, inclusive:**

SELECT 
    *
FROM
    sakila.film
WHERE
    rental_rate >= 2.99
        AND rental_rate <= 4.99;

8. **Retrieve all actors with a last name containing 'son' and order by last name:**

SELECT 
    *
FROM
    sakila.actor
WHERE
    last_name LIKE '%son%'
ORDER BY last_name;

9. **Find all stores in city 'Los Angeles' and sort by store ID:**

SELECT * FROM sakila.city where city='Los Angeles' order by city_id;

10. **Display all films with a replacement cost greater than 20 and sort by replacement cost in ascending order:**

SELECT 
    *
FROM
    sakila.film
WHERE
    replacement_cost >= 20
ORDER BY replacement_cost ASC;

11. **List all films with a length greater than 120 minutes:**

SELECT 
    *
FROM
    sakila.film
WHERE
   length>120;
   
   

12. **Find all customers who have an active status (status = 1):**

SELECT 
    *
FROM
    sakila.customer
WHERE
    active = 1;
   
13. **Retrieve all films with a rental rate of 0.99 and sort them by length in descending order:**
SELECT 
    *
FROM
    sakila.film
WHERE
    rental_rate = 0.99
ORDER BY length;

   
14. **Display all actors with a first name containing 'Tom' and order by last name:**

SELECT 
    *
FROM
    sakila.actor
WHERE
    first_name LIKE '%tom%'
ORDER BY last_name;
   
15. **Find all films with a replacement cost less than 15 and sort them by title:**

	SELECT 
    *
FROM
    sakila.film
WHERE
    replacement_cost < 15
ORDER BY title;

16. **List all customers with a last name ending with 'son':**

SELECT 
    *
FROM
    sakila.customer
WHERE
    last_name LIKE '%son';

17. **Retrieve all films with a rating of 'R' and sort them by rental duration:**

SELECT 
    *
FROM
    sakila.film
WHERE
    rating = 'r'
ORDER BY rental_duration;

18. **Find all actors with a last name exactly equal to 'Smith' and order by first name:**
SELECT 
    *
FROM
    sakila.actor
    where last_name = "Smith" order by first_name;


19. **Display all films with a rental duration of exactly 7 days and sort by replacement cost:**

SELECT 
    *
FROM
    sakila.film
WHERE
    rental_duration = 7
ORDER BY replacement_cost;

20. **List all customers with a first name starting with 'A' and order by last name in ascending order:**

SELECT 
    *
FROM
    sakila.customer
WHERE
    first_name LIKE 'a%'
ORDER BY last_name;

21. **Retrieve all films with a rental duration between 3 and 7 days and a rental rate greater than 2.99:**

SELECT 
    *
FROM
    sakila.film
WHERE
    rental_duration > 3
        AND rental_duration < 7
        AND rental_rate > 2.99;

22. **List all customers who live in 'New York' or 'Los Angeles':**
SELECT 
    *
FROM
    sakila.customer
WHERE
    address_id IN (SELECT 
            address_id
        FROM
            sakila.address
        WHERE
            city_id IN (SELECT 
                    city_id
                FROM
                    sakila.city
                WHERE
                    city = 'Junan' OR city = 'José Azueta'));

/* 23. *Find all films with a rating of 'PG' or 'G' and a length less than 90 minutes:*
*/
select * from film where rating='PG' or rating='G' and length <'90';

/* 24. *Display all actors with a first name containing 'Sam' or a last name starting with 'B':*
*/
select * from actor where first_name='Sam' or last_name ='B%' ;

/* 25. *Retrieve all films with a replacement cost between 15 and 25 and sort them by title:*
*/
select * from film where replacement_cost between '15' and '25' order by title;

/* 26. *Find all customers who have rented a film in the last month and have an active status (status = 1):*
*/
select * from customer where rental in(select date from film where date='');

SELECT 
    customer.customer_id,
    customer.first_name,
    customer.last_name,
    MAX(rental.rental_date) AS last_rental_date
FROM
    rental
        JOIN
    customer ON rental.customer_id = customer.customer_id
WHERE
    rental.customer_id IN (SELECT 
            customer.customer_id
        FROM
            customer
        WHERE
            customer.active = 1)
GROUP BY rental.customer_id;

/* 27. *List all films with a rental rate of 4.99, 3.99, or 2.99:*
*/
select * from film where rental_rate in(4.99, 3.99, 2.99);

/* 28. *Retrieve all actors with a first name starting with 'M' and a last name ending with 'y':*
*/
select * from actor where first_name='M%' and last_name='Y';

/* 29. *Find all films released in the years 2005, 2006, or 2007 and sort them by release year:*
*/
select * from film where release_year in(2005, 2006, 2007) order by release_year;

/* 30. *Display all customers with a first name of 'Emily' or a last name containing 'Lee':*
*/
select * from customer where first_name='Emily' or last_name='Lee';
