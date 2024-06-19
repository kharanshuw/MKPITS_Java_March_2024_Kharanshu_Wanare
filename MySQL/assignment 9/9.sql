/*1.Retrieve the names of customers who rented the film with the title 
'Inception'.*/
SELECT 
    c.customer_id, c.FIRST_name
FROM
    customer c
        JOIN
    rental r ON r.customer_id = c.customer_id
        JOIN
    inventory i ON i.inventory_id = r.inventory_id
        JOIN
    film f ON f.film_id = i.film_id
WHERE
    f.title = 'MASK PEACH';

/*2.Retrieve the titles of films rented by a customer with a given 
customer_id.*/
SELECT 
    f.title
FROM
    film f
        JOIN
    inventory i ON i.film_id = f.film_id
        JOIN
    rental r ON r.inventory_id = i.inventory_id
WHERE
    r.customer_id = 1;

/*3.Retrieve the rental details for the most recent rental transaction in the 
database.*/
SELECT r.rental_id,r.customer_id
from rental r 
ORDER BY r.rental_date DESC 
limit 1 ;

/*4.Compare the average rental duration of films in a specific category with 
the overall average rental duration.*/
SELECT 
    AVG(f.rental_duration),
    IF((SELECT 
                AVG(rental_duration)
            FROM
                film),
        'greater',
        'smaller')
FROM
    category ct
        JOIN
    film_category fc ON fc.category_id = ct.category_id
        JOIN
    film f ON f.film_id = fc.film_id
        JOIN
    inventory i ON i.film_id = f.film_id
        JOIN
    rental r ON r.inventory_id = i.inventory_id
WHERE
    r.rental_id = 3




/*5.Retrieve films with rental counts greater than the average number of rentals across all films.
- Count film wise rental
- Display films whose rental count is > avg rental count
*/

SELECT 
    COUNT(rental_id) ,
    IF((SELECT 
                AVG(rental.rental_id)
            FROM
                rental) > COUNT(rental_id),
        'smaller',
        'greater')
FROM
    rental r
        JOIN
    inventory i ON i.inventory_id = r.inventory_id
        JOIN
    film f ON f.film_id = i.film_id
WHERE
    f.film_id = 6


/*6. Find customers who rented the same film as another customer:
Identify customers who rented the same film as a specific customer (based on customer_id)
*/

SELECT 
    c.customer_id, c.FIRST_name,f.film_id,f.title
FROM
    customer c
        JOIN
    rental r ON r.customer_id = c.customer_id
        JOIN
    inventory i ON i.inventory_id = r.inventory_id
        JOIN
    film f ON f.film_id = i.film_id
WHERE
    f.film_id =ANY (
	
	SELECT 
    f.film_id
FROM
    customer c
        JOIN
    rental r ON r.customer_id = c.customer_id
        JOIN
    inventory i ON i.inventory_id = r.inventory_id
        JOIN
    film f ON f.film_id = i.film_id
WHERE
    c.customer_id=12
	
GROUP by  f.film_id,c.customer_id
	)
	
	
/*
7. Find customers who have rented from both stores:
Identify customers who have rented films from both store_id 1 and store_id 2.
*/