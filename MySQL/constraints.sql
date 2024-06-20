-- Create the "sd" table
CREATE TABLE sd (
    rollno CHAR(10) NOT NULL,
    name CHAR(20),
    address VARCHAR(40),
    city CHAR(10) DEFAULT 'nagpur',
    PRIMARY KEY (rollno),
    UNIQUE (name)
);
INSERT INTO sd (rollno, name, address, city) VALUES ('3001', 'Michael Jordan', '23 Air Jordan Blvd', 'Chicago');
INSERT INTO sd (rollno, name, address, city) VALUES ('4004', 'Marie Curie', '11 Rue Pierre Curie', 'Paris');
INSERT INTO sd (rollno, name, address, city) VALUES ('5005', 'Leonardo da Vinci', '1 Via Niccolò Machiavelli', 'Florence');
INSERT INTO sd (rollno, name, address, city) VALUES ('6006', 'Stephen Hawking', 'Gonville & Caius College, Cambridge', 'Cambridge');
INSERT INTO sd (rollno, name, address, city) VALUES ('7007', 'Malala Yousafzai', 'Birmingham, United Kingdom', 'Birmingham');
INSERT INTO sd (rollno, name, address, city) VALUES ('8008', 'Wolfgan Mozart', 'Getreidegasse 9, Salzburg', 'Salzburg');
INSERT INTO sd (rollno, name, address, city) VALUES ('9009', 'Nelson Mandela', 'Robben Island, South Africa', 'Cape Town');  -- Robben Island is near Cape Town
INSERT INTO sd (rollno, name, address, city) VALUES ('1010', 'Albert Einstein', 'Bern, Switzerland', 'Bern');
INSERT INTO sd (rollno, name, address, city) VALUES ('1111', 'Amelia Earhart', 'Atchison, Kansas', 'Atchison');
INSERT INTO sd (rollno, name, address, city) VALUES ('1212', 'Frida Kahlo', 'Mexico City, Mexico', 'Mexico City');




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
    (1, 85, 90, 95),
    (2, 78, 82, 88),
    (3, 65, 75, 70),
    (4, 90, 85, 92),
    (5, 80, 78, 84),
    (6, 72, 68, 75),
    (7, 92, 90, 88),
    (8, 88, 80, 85),
    (9, 75, 70, 65),
    (10, 82, 85, 80);




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

