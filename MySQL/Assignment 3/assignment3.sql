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
select (abs(length-rental_duration
) )from film 

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

/*21 Extract the year from the rental date for each rental*/
select year(rental_date) from rental

/* 22. **Find the day of the week for each rental date.**
 */
select weekday(rental_date) from rental

/* 23. **Calculate the age of each customer based on their create_date.**
*/
SELECT 
    FLOOR(DATEDIFF(CURDATE(), DATE(create_date)) / 365)
FROM
    customer
/**/

/*24. **Add 7 days to the rental date to get the return due date for each rental.**
*/
select date_add(rental_date+interval 7 day) from rental

/*25  Get the month name from the rental date for each rental*/

select monthname(rental_date) from rental

/*26. **Extract the hour from the last update timestamp of each film.**
*/
last_update

select hour(last_update) from film

/*27.Calculate the difference in days between the return date and rental date for each rental.*/

select datediff(return_date,rental_date) from rental	

/*28. **Find the first day of the month for each rental date.**
*/
SELECT rental_date, DATE_FORMAT(rental_date, '%Y-%m-01') AS first_day_of_month
FROM rental;

/*29 **Format the rental date as 'DD-MM-YYYY' for each rental.** */

select date_format(rental_date,'%D-%M-%Y') from rental

/*30. **Extract the quarter from the rental date for each rental.**
*/
select quarter(rental_date) from rental;

/*31*  **Find the ASCII value of the first character of each film title.**
/
select ascii (substring(title,1,1))  from film

/*
32. **Return the binary representation of the film_id for each film.**
*/
select bin(film_id) from film

/*33. **Convert the rental duration of each film to a hexadecimal value.**
*/
select hex(rental_duration) from film

/*34 Find all films with a replacement cost that is a power of 2.*/
SELECT title, replacement_cost
FROM film
WHERE (replacement_cost & (replacement_cost - 1)) = 0
AND replacement_cost > 0;

/*35 Check if the length of the film title is even or odd */

SELECT title,if((length)%2=0,even,odd)
FROM film;

/*36. **Find all films with a rental rate greater than 3 and categorize them as 'High' or 'Low'.**
*/
SELECT 
    f.film_id,
    f.title,
    f.rental_rate,
    CASE
        WHEN f.rental_rate > 3 THEN 'High'
        ELSE 'Low'
    END AS rental_category
FROM
    film f;

SELECT 
    f.film_id,
    f.title,
    f.rental_rate,
    IF(f.rental_rate > 3, 'High', 'Low') AS rental_category
FROM
    film f;
	
/*37.Return the IP address equivalent of the film_id for the first 10 films.*/



/*38.Select the 3rd character of each film title*/
SELECT 
    f.title, SUBSTR(f.title, 3, 1) AS substring_of_title
FROM
    film f;
	
/*39.Return the Unicode code point of the first character of each actor's first name*/
Select f.title LPAD(CONCAT(cast(bit_or(f.rental_rate>>7,f.rental_rate & 1) as CHAR)),8,'0')as rental_rate_binary
from film f;

Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '(CONCAT(cast(bit_or(f.rental_rate>>7,f.rental_rate & 1) as CHAR)),8,'0') as rent' at line 1
