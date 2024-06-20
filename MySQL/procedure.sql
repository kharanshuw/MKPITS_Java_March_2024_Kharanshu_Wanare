--procedure 

delimiter --
use student--
CREATE procedure mysp ()
BEGIN 
SELECT * FROM sd ;
end --
delimiter ; 


call mysp();


DROP procedure mysp IF EXISTS();



SELECT * FROM sd WHERE rollno=10



delimiter -- 
use student--
CREATE procedure find_student(IN rn INTEGER)
BEGIN
SELECT * FROM sd WHERE rollno=rn;

end --

delimiter ;

call find_student(003)

DROP procedure find_student



*************

delimiter -- 
use student--
CREATE procedure find_student(IN rn INTEGER ,OUT ADD)
BEGIN
SELECT address INTO ADD FROM sd WHERE rollno=rn;
end--
delimiter ;

DROP PROCEDURE find_student;
call find_student(003,@aa);

**********

delimiter -- 
use student--
CREATE procedure find_student(INOUT var1 VARCHAR(40))
BEGIN
SELECT name INTO var1 FROM sd WHERE rollno=var1;
end--
delimiter ;

DROP PROCEDURE find_student;

set @aa='003'

call find_student(@aa);

SELECT @aa

