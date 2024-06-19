/*roblem Statement 1: Retrieve Customer Information with Rental History
Retrieve the customer's first name, last name, and the number of rentals they have made. Include customers who have not made any rentals as well.*/

SELECT c.first_name, c.last_name, COALESCE(COUNT(r.rental_id), 0) AS number_of_rentals
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name;


/*Problem Statement 2: Display Films and Their Rental Count
Display film titles along with the number of times each film has been rented. Include films that have not been rented at all.*/
SELECT f.title, COALESCE(COUNT(ri.rental_id), 0) AS rental_count
FROM film f
LEFT JOIN inventory i ON f.film_id = i.film_id
LEFT JOIN rental ri ON ri.inventory_id = i.inventory_id
GROUP BY f.film_id, f.title;


/*Problem Statement 3: List Customers and Their Rentals
List customers with their rental details (rental ID, rental date, and return date if available). Include customers who have not made any rentals.
*/

SELECT c.customer_id, c.first_name, c.last_name,r.rental_id, r.rental_date, 
		r.return_date,count(r.rental_id)
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
GROUP by c.customer_id,r.rental_id
order by r.rental_id;

/*Problem Statement 4: Show Films and Customers Who Rented Them
Display film titles and the names of customers who have rented each film. Include films that have not been rented.*/
SELECT f.title,c.customer_id,c.first_name,c.last_name,r.rental_id as rentalid,count(r.rental_id)
FROM film f 
LEFT JOIN inventory i 
ON i.film_id=f.film_id
LEFT JOIN Rental r 
ON r.inventory_id=i.inventory_id
LEFT JOIN Customer c 
ON c.customer_id=r.customer_id
GROUP by f.film_id,c.customer_id,r.rental_id
order by rentalid,f.title

/*Problem Statement 5: Explore Rental Returns and Late Fees
Retrieve rental ID, return date, and any associated late fees. Include rentals that have not been returned yet, displaying a NULL return date for these rentals.
*/

SELECT c.customer_id,r.rental_id,r.rental_date,Count(r.rental_id)
FROM Customer c 
right JOIN Rental r 
ON r.customer_id=c.customer_id
GROUP by c.customer_id,r.rental_id;


/*6.Retrieve Films and Rental Details
Retrieve film titles and rental details (rental ID, rental date, and return date if available). Include films that have not been rented.*/

SELECT c.customer_id, c.first_name, c.last_name,r.rental_id, r.rental_date, 
		r.return_date,count(r.rental_id)
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
GROUP by c.customer_id,r.rental_id
order by r.rental_id;


/*7. Display Rentals and Associated Customers
Display rental details (rental ID, rental date, and return date if available) along with the names of customers who made those rentals. Include rentals that have not been rented.*/

SELECT c.customer_id, c.first_name, c.last_name,r.rental_id, r.rental_date, 
		r.return_date,count(r.rental_id)
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
GROUP by c.customer_id,r.rental_id
order by r.rental_id;

/*8.List Payments with Customer Information
List payment details (payment ID, amount, and payment date) along with the names of customers who made those payments. Include payments that have not been made.*/

SELECT p.payment_id, p.amount, p.payment_date,
       c.first_name, c.last_name
FROM payment p
LEFT JOIN customer c ON p.customer_id = c.customer_id
ORDER BY p.amount;

