/*### Problem Statement 1
**Create a view named `customer_rental_info` that lists each customer's full name (first and last), email, the number of rentals they have made, and the total amount they have spent on rentals.**
*/
Create view customer_rental_info
AS
SELECT c.first_name,c.last_name,COUNT(p.payment_id),COUNT(r.rental_id)
FROM customer c 
join rental r 
on r.customer_id=c.customer_id
join payment p 
on p.rental_id=r.rental_id
GROUP BY c.customer_id;

SELECT * FROM customer_rental_info

DROP VIEW customer_rental_info

/*### Problem Statement 2
**Create a view named `top_rented_films` that displays the top 10 most rented films, including the film title and the number of times it has been rented.***/
CREATE VIEW top_rented_films as

SELECT f.film_id,f.title,COUNT(r.rental_id) as rentals
FROM film f 
join inventory i 
on i.film_id=f.film_id
join rental r 
on r.inventory_id=i.inventory_id
GROUP BY r.rental_id
ORDER BY rentals DESC
limit 10;

/*### Problem Statement 3
**Create a view named `active_customers` that lists all customers who have rented at least one film in the last 30 days. Include the customer's full name, email, and the date of their last rental.**
*/

Create view active_customers
as

SELECT c.first_name, c.last_name, c.email, MAX(r.rental_date) AS last_rental_date
FROM customer c
JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name, c.email
HAVING max(r.rental_date) <= DATE_SUB(MAX(r.rental_date), INTERVAL 30 DAY)
AND COUNT(r.rental_id) > 1;


/*### Problem Statement 4
**Create a view named `inventory_by_store` that displays the number of films available in each store. Include the store ID and the count of films available in that store.***/

Create view inventory_by_store
as
SELECT count(f.film_id),s.store_id
FROM film f 
join inventory i 
on i.film_id=f.film_id 
join store s 
on s.store_id=i.store_id
GROUP BY s.store_id


/*### Problem Statement 5
**Create a view named `staff_sales_performance` that lists each staff member's full name, their store, and the total sales amount they have made.**
*/
SELECT s.first_name,s.last_name,SUM(p.amount)
from staff s 
join STORE st 
on st.store_id=s.store_id
join payment p 
on p.staff_id=s.staff_id
GROUP by s.staff_id;

