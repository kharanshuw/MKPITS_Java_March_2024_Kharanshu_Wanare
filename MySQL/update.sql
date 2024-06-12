--update existing data
ff

update student.studentdetails
set address="xyz" where rollno=1007

--DELETE ROW
DELETE FROM student.studentdetails
WHERE rollno=1007