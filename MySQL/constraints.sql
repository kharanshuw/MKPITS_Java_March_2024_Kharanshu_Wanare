-- Create the "sd" table
CREATE TABLE sd (
    rollno CHAR(10) NOT NULL,
    name CHAR(20),
    address VARCHAR(40),
    city CHAR(10) DEFAULT 'nagpur',
    PRIMARY KEY (rollno),
    UNIQUE (name)
);

-- Insert 10 records into the "sd" table
INSERT INTO sd (rollno, name, address)
VALUES
    ('001', 'John Smith', '123 Main St'),
    ('002', 'Jane Doe', '456 Elm St'),
    ('003', 'Michael Johnson', '789 Oak St'),
    ('004', 'Emily Brown', '222 Pine St'),
    ('005', 'Robert Johnson', '555 Maple St'),
    ('006', 'Sophia Anderson', '987 Birch St'),
    ('007', 'David Lee', '666 Walnut St'),
    ('008', 'Olivia Wilson', '333 Elm St'),
    ('009', 'Benjamin Parker', '111 Oak St'),
    ('010', 'Isabella Martinez', '777 Pine St');

CREATE TABLE md (
    rollno CHAR(10),
    physics INTEGER CHECK (physics BETWEEN 0 AND 100),
    chemistry INTEGER CHECK (chemistry BETWEEN 0 AND 100),
    maths INTEGER CHECK (maths BETWEEN 0 AND 100),
    CONSTRAINT fk_rn FOREIGN KEY (rollno)
        REFERENCES sd (rollno)
)

-- Insert 10 records into the "md" table
INSERT INTO md (rollno, physics, chemistry, maths)
VALUES
    ('001', 85, 90, 95),
    ('002', 78, 82, 88),
    ('003', 65, 75, 70),
    ('004', 90, 85, 92),
    ('005', 80, 78, 84),
    ('006', 72, 68, 75),
    ('007', 92, 90, 88),
    ('008', 88, 80, 85),
    ('009', 75, 70, 65),
    ('010', 82, 85, 80);



/*DELETE VALUE IN table*/
DELETE FROM md WHERE rollno=1;
DELETE FROM sd WHERE rollno =1;
--DELETE table 
drop table studentmarks
drop table studentdetails


/*NOT NULL on ALTER TABLE*/
ALTER table sd
MODIFY rollno INTEGER NOT NULL;

/*UNIQUE Constraint on ALTER TABLE*/
ALTER table sd 
ADD UNIQUE (rollno)

ALTER table sd 
ADD CONSTRAINT uq_rn UNIQUE (rollno);

/*PRIMARY KEY*/
ALTER table sd
ADD PRIMARY KEY(rollno);

ALTER table sd
ADD CONSTRAINT pm_rm PRIMARY KEY (rollno);

/*FOREIGN KEY*/
ALTER table md 
ADD FOREIGN KEY (rollno) REFERENCES sd(rollno);

ALTER table md
ADD CONSTRAINT fk_rn FOREIGN KEY(rollno) REFERENCES sd(rollno);

/*CHECK KEY*/
ALTER table sd
ADD CHECK (physics BETWEEN 0 AND 100);

ALTER table sd
ADD CONSTRAINT ch_ph CHECK (physics BETWEEN 0 AND 100);

/*DEFAULT*/
ALTER table md
ALTER city set DEFAULT 'nagpur'

ALTER table md
ALTER city drop DEFAULT;

