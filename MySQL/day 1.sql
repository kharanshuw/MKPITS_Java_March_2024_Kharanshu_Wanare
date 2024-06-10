use sakila;

show tables;

select * from actor

--use of WHERE
select * from actor WHERE first_name='PENELOPE';

--use of AND
select * from actor WHERE first_name='PENELOPE' AND last_name='CRONYN';

--When querying data from a table, you may get duplicate rows. To remove these duplicate rows, you use the DISTINCT clause in the SELECT statement.

select DISTINCT first_name from actor;

--CONCAT function example
SELECT 
    first_name, last_name, CONCAT(first_name, ' ', last_name)
FROM
    actor_info
ORDER BY first_name , last_name DESC , CONCAT(first_name, last_name);