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

/*Round the rental rate of each film to 2 decimal places*/
rental_rate
select Round(rental_rate,1) from film

/*Calculate the square root of the replacement cost of each film*/
replacement_cost
select SQRT(replacement_cost) from film