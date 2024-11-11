create table student
(
id int ,
first_name varchar(100),
last_name varchar(100),
CONSTRAINT pk_id PRIMARY KEY (id)
);


ALTER table student 
ADD COLUMN id int 