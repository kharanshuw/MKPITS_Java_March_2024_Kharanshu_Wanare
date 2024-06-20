--index
CREATE INDEX [index_name] ON [table_name] (column names)  

CREATE index ind_ct_sd on sd(city)

show indexes from sd 

ALTER TABLE sd 
DROP index ind_ct_sd

--to get list of CONSTRAINTS on all DATABASE
select * from information_schema.table_constraints

