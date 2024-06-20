/*Problem Statement 1: 
Calculate Late Fees for Rentals
Design a stored procedure that calculates late fees for rentals based on the 
return date and the due date. The procedure should take the rental ID as input 
and update the late fee for the corresponding rental.*/

delimiter --
use sakila --
CREATE procedure late_fees(IN re_id INTEGER)
BEGIN 
	
	SELECT rental_date,return_date
	FROM rental 
	WHERE rental_id=re_id;


end -- 

delimiter ;


call late_fees(5);


/*2.Generate a Rental Receipt
Create a stored procedure that generates 
write a query for rental receipt for a EACH rental ID.
The receipt should include rental details, customer information, and total cost. 
The procedure should output the receipt to the console.
*/
delimiter --
use sakila --
Create procedure Rental_Receipt(IN r_id INTEGER) 
BEGIN
SELECT 
  p.rental_id,
  p.customer_id,
  c.first_name,
  p.payment_id, 
  SUM(p.amount) AS total_amount_paid
FROM payment p
INNER JOIN customer c ON p.customer_id = c.customer_id
WHERE p.rental_id=r_id
GROUP BY p.rental_id, p.customer_id, c.first_name, p.payment_id;  

end --

delimiter ;

call Rental_Receipt(3);