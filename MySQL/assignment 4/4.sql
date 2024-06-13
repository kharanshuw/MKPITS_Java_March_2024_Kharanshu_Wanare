/*1.Retrieve the names of all customers and the titles of the films they have
rented*/
SELECT
          CONCAT(c.first_name, ' ', c.last_name) AS customer_name,
          f.title                                AS film_title
FROM
          customer c
JOIN
          rental r
ON
          c.customer_id = r.customer_id
JOIN
          inventory i
ON
          r.inventory_id = i.inventory_id
JOIN
          film f
ON
          i.film_id = f.film_id
ORDER BY
          customer_name,
          film_title;
/*2. Display the rental date and return date for each rental along with the
customer's first name and last name*/
SELECT
          r.rental_date,
          r.return_date,
          c.first_name ,
          c.last_name
FROM
          rental r
JOIN
          customer c
ON
          c.customer_id = r.customer_id
ORDER BY
          c.last_name ASC  ,
          c.first_name ASC ,
          r.rental_date ASC;
/*3.List the names of actors who have appeared in the film titled "Chamber
Italian
*/
SELECT
          a.first_name ,
          a.last_name  ,
          f.title
FROM
          actor a
JOIN
          film_actor fa
on  	 fa.actor_id =a.actor_id

JOIN	film f
on f.film_id =fa.film_id

/*4.Get the titles of all films rented by the customer named "William Brown*/

SELECT f.title,c.first_name
FROM customer c
JOIN rental r 
on r.customer_id=c.customer_id
JOIN inventory i
on 	i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.first_name="amber"

/*5. Retrieve the film titles rented by the customer with customer_id 100*/
SELECT f.title,c.customer_id
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.customer_id=100
order by title asc;

/*5 List the film titles and rental dates for all rentals made by the customer with 
customer_id 200.*/

SELECT c.customer_id,r.rental_date,f.title
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.customer_id=200;

+-------------+---------------------+-----------------------+
| customer_id | rental_date         | title                 |
+-------------+---------------------+-----------------------+
|         200 | 2005-05-26 16:20:56 | AUTUMN CROW           |
|         200 | 2005-06-15 09:23:59 | GRIT CLOCKWORK        |
|         200 | 2005-06-15 10:10:49 | LEAGUE HELLFIGHTERS   |
|         200 | 2005-06-17 04:29:15 | CREATURES SHAKESPEARE |
|         200 | 2005-06-18 03:43:23 | SHOW LORD             |
|         200 | 2005-06-19 11:28:46 | DIARY PANIC           |
|         200 | 2005-06-19 14:46:10 | ANTHEM LUKE           |
|         200 | 2005-06-20 23:27:15 | BLACKOUT PRIVATE      |
|         200 | 2005-07-06 03:48:44 | STAR OPERATION        |
|         200 | 2005-07-09 06:57:25 | ATLANTIS CAUSE        |
|         200 | 2005-07-11 08:02:27 | FACTORY DRAGON        |
|         200 | 2005-07-11 10:21:21 | REAP UNFAITHFUL       |
|         200 | 2005-07-11 11:10:11 | WASH HEAVENLY         |
|         200 | 2005-07-26 23:42:03 | COLOR PHILADELPHIA    |
|         200 | 2005-07-27 22:53:00 | BERETS AGENT          |
|         200 | 2005-07-29 05:15:41 | FEUD FROGMEN          |
|         200 | 2005-07-29 08:15:42 | SHRUNK DIVINE         |
|         200 | 2005-07-31 01:02:24 | MANCHURIAN CURTAIN    |
|         200 | 2005-08-01 17:49:38 | HUNTING MUSKETEERS    |
|         200 | 2005-08-02 17:42:40 | BETRAYED REAR         |
|         200 | 2006-02-14 15:16:03 | MULHOLLAND BEAST      |
|         200 | 2005-08-20 10:41:50 | VIDEOTAPE ARSENIC     |
|         200 | 2005-08-20 21:31:52 | SATURDAY LAMBS        |
|         200 | 2005-08-21 15:01:32 | FRENCH HOLIDAY        |
|         200 | 2005-08-23 09:53:54 | CONEHEADS SMOOCHY     |
|         200 | 2005-08-23 12:11:37 | EXPENDABLE STALLION   |
|         200 | 2005-08-23 19:35:42 | SWEET BROTHERHOOD     |
+-------------+---------------------+-----------------------+

/*
7.Display the film titles and rental durations for all rentals made on May 15, 2005*/
SELECT DATEDIFF(r.return_date, r.rental_date) AS rental_duration,f.title
FROM film f
JOIN inventory i 
on i.film_id=f.film_id
JOIN rental r
on r.inventory_id=i.inventory_id
WHERE date(r.rental_date)='2005-05-15'

/*8.List the names of customers who have rented the film titled "Alien Center".*/
SELECT c.first_name ,f.title
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE f.title="Alien Center"
+------------+--------------+
| first_name | title        |
+------------+--------------+
| CARMEN     | ALIEN CENTER |
| CHARLIE    | ALIEN CENTER |
| HEIDI      | ALIEN CENTER |
| ROGER      | ALIEN CENTER |
| KELLY      | ALIEN CENTER |
| MICHEAL    | ALIEN CENTER |
| MARGIE     | ALIEN CENTER |
| ALAN       | ALIEN CENTER |
| ANA        | ALIEN CENTER |
| JACQUELINE | ALIEN CENTER |
| JIM        | ALIEN CENTER |
| CURTIS     | ALIEN CENTER |
| HEATHER    | ALIEN CENTER |
| ROBERTA    | ALIEN CENTER |
| JEFF       | ALIEN CENTER |
| BYRON      | ALIEN CENTER |
| FRANCES    | ALIEN CENTER |
| MARIA      | ALIEN CENTER |
| JEROME     | ALIEN CENTER |
| CINDY      | ALIEN CENTER |
| ANTONIO    | ALIEN CENTER |
| ANDY       | ALIEN CENTER |
+------------+--------------+
22 rows in set (0.00 sec)

/*9.Display the first name, last name, and email of customers who have rented the 
film titled "Flight Lies"*/
SELECT c.first_name ,c.last_name,c.email
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE f.title='Flight Lies';

/*10 Retrieve the rental date and rental duration for each rental made by customer 
"Linda Williams".*/
SELECT * FROM customer

SELECT r.rental_date,f.rental_duration,c.first_name,c.last_name
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.first_name='Linda' AND c.last_name='Williams';


/*11 List the film titles and rental dates for all rentals made by customer "Mary 
Johnson"*/

SELECT f.title,r.rental_date,c.first_name
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.first_name='Mary' AND c.last_name='Johnson';

/*12.Display the film titles rented by the customer with customer_id 300.*/

SELECT f.title,c.first_name, c.customer_id
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.customer_id=300;

/*13.Get the names of all customers who have rented more than 5 films*/
SELECT c.first_name,c.last_name
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
GROUP by c.customer_id
HAVING COUNT(r.rental_id)>5;
******************************************
/*14.List the film titles and rental dates for all rentals made by the customer with 
customer_id 400.*/
SELECT f.title,r.rental_date,c.first_name
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.customer_id=400;


/*15.Retrieve the rental date and return date for each rental made by customer 
"Richard Davis".
*/

SELECT r.rental_date,c.first_name,r.return_date
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
WHERE c.first_name='Richard' and c.last_name='Davis';

/*16.Display the first name, last name, and email of customers who have rented the 
film titled "Dinosaur Secretary*/

SELECT c.first_name,c.last_name,c.email,f.title
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE f.title='Dinosaur Secretary';

/*17.List the names of customers who have rented the film titled "Silence Kane".*/

SELECT c.first_name,c.last_name,f.title
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE f.title='Silence Kane';

/*18.Get the film titles and rental dates for all rentals made on August 10, 2005.*/

SELECT r.rental_date,f.title
FROM  rental r
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE date(r.rental_date)='2005-08-10';

/*19.Retrieve the film titles rented by the customer with customer_id 500.*/
SELECT c.first_name,c.last_name,f.title
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
JOIN inventory i
on i.inventory_id=r.inventory_id
JOIN film f
on f.film_id=i.film_id
WHERE c.customer_id=500;

/*20. Display the rental date and rental duration for each rental made by customer 
"Karen Smith"*/
SELECT r.rental_date,DATEDIFF(r.rental_date,r.return_date) as rental_duration
FROM customer c
JOIN rental r
on r.customer_id=c.customer_id
WHERE c.first_name='Karen' and c.last_name='Smith';