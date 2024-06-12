/*### Problem 1:
**Find the total number of films in the database.***/

SELECT COUNT(*) FROM film

/*### Problem 2:
**Find the average rental rate of all films.***/

SELECT AVG(rental_rate) FROM film

/*### Problem 3:
**Find the total number of rentals made.***/
SELECT COUNT(*) FROM rental

/*### Problem 4:
**Find the highest replacement cost of any film.**
*/

SELECT MAX(replacement_cost) FROM film

/*### Problem 5:
**Find the total revenue generated from rentals.***/

SELECT COUNT(rental_rate) from film

/*### Problem 6:
**Find the average length of films.***/

SELECT COUNT(length) from film
/*### Problem 7:
**Find the minimum rental duration among all films.***/
SELECT MIN(rental_duration) from film

/*### Problem 8:
**Find the total number of distinct customer IDs in the rental table.***/

SELECT COUNT(DISTINCT rental_id) from rental

/*### Problem 9:
**Find the average payment amount made by customers.***/

SELECT AVG(amount) FROM payment

/*### Problem 10:
**Find the total number of inventory items available.** */

SELECT COUNT(inventory_id) FROM inventory

/*### Problem 11:
**Find the total number of distinct films rented.***/



/*### Problem 12:
**Find the highest payment customer amount made by any customer.***/

SELECT MAX(amount) from payment

/*### Problem 13:
**Find the average length of films that have a rating of 'PG'.**
*/

SELECT AVG(length) from film WHERE rating="pg"
/*### Problem 14:
**Find the total number of payments made in May 2005.***/
SELECT COUNT(*)
FROM payment
WHERE YEAR(payment_date) = 2005 AND MONTH(payment_date) = 5;

/*### Problem 15:
**Find the total number of films with a rental duration of 7 days.***/

SELECT COUNT(*) from film where rental_duration=7

/*### Problem 16:
**Find the average replacement cost of films with a rental rate of 2.99.**
*/

SELECT AVG(replacement_cost) from film WHERE rental_rate=2.99

SELECT 
    AVG(replacement_cost)
FROM
    film
WHERE
    rental_rate = 2.99