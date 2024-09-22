SELECT email, name, COUNT(*)
FROM sample_table
GROUP BY name, email
HAVING COUNT(*) > 1;