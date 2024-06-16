/*1.Find categories with an average rental revenue greater than $10.*/

select c.category_id,avg(p.amount)
from category c
join film_category fc on fc.category_id=c.category_id
join film f on f.film_id=fc.film_id
join inventory i on i.film_id=f.film_id
join rental r on r.inventory_id=i.inventory_id
join payment p on p.rental_id=r.rental_id
group by c.category_id 
having avg(p.amount)>4;

/*2.Identify customers who have rented more than 30 films.
*/

select c.customer_id,c.first_name,c.last_name
from customer c
join rental r on r.customer_id=c.customer_id
group by c.customer_id
having count(r.rental_id)>30

/*3. List of  languages with more than 50 films.*/
select l.language_id,count(f.film_id),l.name
from language l
join film f
on f.language_id= l.language_id
group by l.language_id
having count(f.film_id)>50

/*4.write a mysql query for Find stores with total revenue exceeding $5000. using above sakila database which i provided
*/
SELECT s.store_id,  SUM(p.amount) AS total_revenue
FROM store s
INNER JOIN staff st ON s.store_id = st.store_id  -- Join store with staff
INNER JOIN payment p ON st.staff_id = p.staff_id  -- Join staff with payment
GROUP BY s.store_id
HAVING SUM(p.amount) > 5000;

/*5.Show actors who have appeared in more than 10 films.*/
select a.actor_id,count(f.film_id)
FROM actor a
join film_actor fa
on fa.actor_id=a.actor_id
join film f
on f.film_id=fa.film_id
group by a.actor_id
having count(f.film_id)>10;

/*6.List staff members who have handled more than 500 customer transactions.
  */
 SELECT st.staff_id,count(c.customer_id)
 from staff st
 JOIN store s 
 on s.store_id=st.store_id
 join customer c 
 on c.store_id=s.store_id
 group by staff_id
 having count(c.customer_id)>250;
 
/*7.Identify customers who have rented in the last 30 days.
*/
select c.customer_id,c.first_name,c.last_name,r.rental_date
from customer c 
INNER join rental r on c.customer_id=r.customer_id
WHERE r.rental_date>=DATE('2005-08-20')-INTERVAL 20 DAY;

/*8.List films with an average rental duration of more than 7 days.
*/ 
SELECT f.film_id,f.title
from film f
group by f.film_id
having avg(f.rental_duration);

/*9.Identify films that have been rented more than 30 times.*/
select f.film_id,f.title,count(r.rental_id) 
from film f 
join inventory i 
on i.film_id=f.film_id
join rental r 
on r.inventory_id=i.inventory_id
group by f.film_id
having count(r.rental_id)>30;

/*10.Find customers who have rented films from at least 5 different categories.
*/
select c.customer_id,c.first_name
from customer c 
join store st on st.store_id=c.store_id
join inventory i on i.store_id=st.store_id
join film f on f.film_id=i.film_id
join film_category fa on fa.film_id=f.film_id
join category ca on ca.category_id=fa.category_id
group by c.customer_id
having count(ca.category_id)>5;