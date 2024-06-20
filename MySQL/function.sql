delimiter --
CREATE FUNCTION avg_calculator (var1 INT, var2 INT, var3 INT)
RETURNS INTEGER
DETERMINISTIC
BEGIN
  DECLARE r1 INT DEFAULT 0;
  SET r1 = (var1 + var2 + var3) / 3; 
  RETURN r1;
END --
delimiter ;


SELECT avg_calculator(15,20,30);


SELECT rollno,avg_calculator(physics,chemistry,maths) ,physics,chemistry,maths FROM md;