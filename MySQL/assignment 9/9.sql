/*1.Retrieve the names of customers who rented the film with the title 
'Inception'.*/
SELECT c.customer_id,c.FIRST_name
FROM customer c 
join rental r 
ON r.customer_id=c.customer_id
join inventory i 
on i.inventory_id=r.inventory_id
join film f 
on f.film_id=i.film_id
WHERE f.title='MASK PEACH';

/*2.Retrieve the titles of films rented by a customer with a given 
customer_id.*/
SELECT f.title 
FROM film f 
join inventory i 
on i.film_id=f.film_id
join rental r 
on r.inventory_id=i.inventory_id
WHERE r.customer_id=?;

/*3.Retrieve the rental details for the most recent rental transaction in the 
database.*/
SELECT r.rental_id,r.customer_id
from rental r 
ORDER BY r.rental_date DESC 
limit 1 ;

/*4.Compare the average rental duration of films in a specific category with 
the overall average rental duration.*/
SELECT (
SELECT avg(r.rental_duration)
from rental r 
inner join inventory i on r.inventory_id =i.inventory_id 
inner join film f on i.film_id =f.film_id 
WHERE f.category_id=1) as cat_1_avg,
avg(rental_duration) as overall_avg from rental r 
inner join inventory i 
on r.inventory_id=i.inventory_id
inner join film f on i.film_id = f.film_id;

/*5.Retrieve films with rental counts greater than the average number of 
rentals across all films.
- Count film wise rental
- Display films whose rental count is > avg rental count
*/
SELECT f.title, COUNT(r.rental_id) AS rental_count
FROM film f
INNER JOIN inventory i ON f.film_id = i.film_id
INNER JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY f.film_id
HAVING COUNT(r.rental_id) > (
  SELECT AVG(rental_count)
  FROM (
    SELECT f.film_id, COUNT(r.rental_id) AS rental_count
    FROM film f
    INNER JOIN inventory i ON f.film_id = i.film_id
    INNER JOIN rental r ON r.inventory_id = i.inventory_id
    GROUP BY f.film_id
  ) AS rental_counts_per_film
);

/*6.Identify customers who rented the same film as a  customer_id 1 
*/



/*7.Identify customers who have rented films from both store_id 1 and 
store_id 2*
*/

