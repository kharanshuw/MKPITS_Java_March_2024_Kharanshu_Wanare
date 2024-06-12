/***Retrieve the first 10 characters of the title of each film.***/
SELECT substring(title ,1 ,10) FROM film

/*Convert the titles of all films to uppercase*/
SELECT ucase(title) FROM film

/*Find the length of each film title*/
SELECT length(title) from film

/*Concatenate the first name and last name of each actor, separated by a space.*/
SELECT 
    CONCAT(first_name, ' ', last_name)
FROM
    actor

/*Replace the word "Action" with "Thriller" in the film description*/

SELECT Replace(description,"Action","Thriller") from film

/*Extract the domain name from the email addresses of all customers*/


/*Find all films whose title starts with the letter 'A'.*/
SELECT title from film WHERE SUBSTR(title,1,1)="A"; 

/*Trim leading and trailing spaces from the first names of customers*/
select trim(first_name) from customer;

/*Find the position of the first occurrence of the word "GREAT" in the film description.*/
select locate("GREAT",description) from film limit 1;

/*Reverse the first name of each customer*/
select Reverse(first_name) from customer

/*11 Round the rental rate of each film to 2 decimal places*/
rental_rate
select Round(rental_rate,1) from film

/*12 Calculate the square root of the replacement cost of each film*/
replacement_cost
select SQRT(replacement_cost) from film

/*13 Find the absolute value of the difference between rental duration and length for each film.*/
rental_duration
length
select cast(abs(rental_duration-length) )from film 

/*14 Raise the rental rate of each film to the power of 3. */
select pow(rental_rate,3) from film

/*15 Get the ceiling value of the replacement cost of each film.*/
select ceil(replacement_cost) from film

/*16  Get the floor value of the replacement cost of each film.*/
select floor(replacement_cost) from film

/*17 Calculate the modulus (remainder) of the rental duration divided by 3 for each film */
select mod(rental_duration,3) from film;

/*18 Get the highest rental rate of all films*/
rental_rate
select max(rental_rate)  from film;

/* 19 Get the lowest replacement cost of all films*/
select min(replacement_cost) from film;

/*20 Get the lowest replacement cost of all films  */
SELECT 
    AVG(length)
FROM
    film

