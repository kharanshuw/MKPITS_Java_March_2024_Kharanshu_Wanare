use bank2;

SELECT * FROM role 

SELECT * from users

SELECT * from userdetails

SELECT * from user_role

SELECT * from role;

SELECT * from account_type

SELECT * from branch

SELECT * from state;

INSERT INTO role(id,role_name) VALUES (1,'ROLE_ADMIN');

INSERT INTO role(id,role_name) VALUES (2,'ROLE_MANAGER');

INSERT INTO role(id,role_name) VALUES (3,'ROLE_USER');

INSERT INTO user_role(role_id,user_id) VALUES(1,1)

INSERT INTO account_type(id,type) VALUES(1,"SAVING ACCOUNT");
INSERT INTO account_type(id,type) VALUES(2,"CURRENT ACCOUNT");
INSERT INTO account_type(id,type) VALUES(3,"RECURRING DEPOSIT ACCOUNT");
INSERT INTO account_type(id,type) VALUES(4,"FIXED DEPOSIT ACCOUNT");

DROP TABLE branch;
DROP TABLE ACCOUNT;
DROP TABLE account_type;

UPDATE users
SET enable = 1 
WHERE id = 1;

UPDATE district
set state_id=15
WHERE state_id = 14

ALTER TABLE branch 
MODIFY COLUMN contact_no VARCHAR(10) NOT NULL,
ADD UNIQUE (contact_no);

ALTER TABLE ACCOUNT
ADD INDEX (id)

ALTER TABLE account_type
ADD INDEX (id)

@Query("SELECT new com.bankapplication.dto.LoggesInUserDetails(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
"FROM User u " + "INNER JOIN u.userDetails ud " +"JOIN u.role r " +"WHERE u.email = :email")
			
			
@Query("SELECT new com.bankapplication.dto.ResponseDto(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
"FROM User u " +
"JOIN u.userDetails ud " +
"JOIN u.role r")
	   
	   
@Query("SELECT new com.bankapplication.dto.ResponseDto(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
"FROM User u " +
"JOIN u.userDetails ud " +
"JOIN u.role r")

//endpoint to call location for testing
http://localhost:9191/api/countries

http://localhost:9191/api/states/1

http://localhost:9191/api/city/1

http://localhost:9191/api/district/1

http://localhost:9191/user/update

http://localhost:9191/


INSERT INTO country(country_name) VALUE('INDIA');

INSERT INTO state(state_name,country_id) VALUE()

INSERT INTO state (state_name, country_id) VALUES ('Andhra Pradesh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Arunachal Pradesh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Assam', 1);
INSERT INTO state (state_name, country_id) VALUES ('Bihar', 1);
INSERT INTO state (state_name, country_id) VALUES ('Chhattisgarh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Goa', 1);
INSERT INTO state (state_name, country_id) VALUES ('Gujarat', 1);
INSERT INTO state (state_name, country_id) VALUES ('Haryana', 1);
INSERT INTO state (state_name, country_id) VALUES ('Himachal Pradesh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Jharkhand', 1);
INSERT INTO state (state_name, country_id) VALUES ('Karnataka', 1);
INSERT INTO state (state_name, country_id) VALUES ('Kerala', 1);
INSERT INTO state (state_name, country_id) VALUES ('Madhya Pradesh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Maharashtra', 1);
INSERT INTO state (state_name, country_id) VALUES ('Manipur', 1);
INSERT INTO state (state_name, country_id) VALUES ('Meghalaya', 1);
INSERT INTO state (state_name, country_id) VALUES ('Mizoram', 1);
INSERT INTO state (state_name, country_id) VALUES ('Nagaland', 1);
INSERT INTO state (state_name, country_id) VALUES ('Odisha', 1);
INSERT INTO state (state_name, country_id) VALUES ('Punjab', 1);
INSERT INTO state (state_name, country_id) VALUES ('Rajasthan', 1);
INSERT INTO state (state_name, country_id) VALUES ('Sikkim', 1);
INSERT INTO state (state_name, country_id) VALUES ('Tamil Nadu', 1);
INSERT INTO state (state_name, country_id) VALUES ('Telangana', 1);
INSERT INTO state (state_name, country_id) VALUES ('Tripura', 1);
INSERT INTO state (state_name, country_id) VALUES ('Uttar Pradesh', 1);
INSERT INTO state (state_name, country_id) VALUES ('Uttarakhand', 1);
INSERT INTO state (state_name, country_id) VALUES ('West Bengal', 1);
INSERT INTO state (state_name, country_id) VALUES ('Jammu & Kashmir', 1);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Delhi', 1,07);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Chandigarh', 1,04);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Lakshadweep', 1,31);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Puducherry', 1,34);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Andaman & Nicobar Islands', 1,35);
INSERT INTO state (state_name, country_id,state_code) VALUES ('Ladakh', 1,38);


INSERT INTO district (district_name, state_id) VALUES ('Ahmednagar', 14);
INSERT INTO district (district_name, state_id) VALUES ('Akola', 14);
INSERT INTO district (district_name, state_id) VALUES ('Amravati', 14);
INSERT INTO district (district_name, state_id) VALUES ('Aurangabad', 14);
INSERT INTO district (district_name, state_id) VALUES ('Beed', 14);
INSERT INTO district (district_name, state_id) VALUES ('Bhandara', 14);
INSERT INTO district (district_name, state_id) VALUES ('Buldhana', 14);
INSERT INTO district (district_name, state_id) VALUES ('Chandrapur', 14);
INSERT INTO district (district_name, state_id) VALUES ('Dhule', 14);
INSERT INTO district (district_name, state_id) VALUES ('Gadchiroli', 14);
INSERT INTO district (district_name, state_id) VALUES ('Gondia', 14);
INSERT INTO district (district_name, state_id) VALUES ('Hingoli', 14);
INSERT INTO district (district_name, state_id) VALUES ('Jalgaon', 14);
INSERT INTO district (district_name, state_id) VALUES ('Jalna', 14);
INSERT INTO district (district_name, state_id) VALUES ('Kolhapur', 14);
INSERT INTO district (district_name, state_id) VALUES ('Latur', 14);
INSERT INTO district (district_name, state_id) VALUES ('Mumbai City', 14);
INSERT INTO district (district_name, state_id) VALUES ('Mumbai Suburban', 14);
INSERT INTO district (district_name, state_id) VALUES ('Nanded', 14);
INSERT INTO district (district_name, state_id) VALUES ('Nandurbar', 14);
INSERT INTO district (district_name, state_id) VALUES ('Nagpur', 14);
INSERT INTO district (district_name, state_id) VALUES ('Nashik', 14);
INSERT INTO district (district_name, state_id) VALUES ('Osmanabad', 14);
INSERT INTO district (district_name, state_id) VALUES ('Palghar', 14);
INSERT INTO district (district_name, state_id) VALUES ('Parbhani', 14);
INSERT INTO district (district_name, state_id) VALUES ('Pune', 14);
INSERT INTO district (district_name, state_id) VALUES ('Raigad', 14);
INSERT INTO district (district_name, state_id) VALUES ('Ratnagiri', 14);
INSERT INTO district (district_name, state_id) VALUES ('Sangli', 14);
INSERT INTO district (district_name, state_id) VALUES ('Satara', 14);
INSERT INTO district (district_name, state_id) VALUES ('Sindhudurg', 14);
INSERT INTO district (district_name, state_id) VALUES ('Solapur', 14);
INSERT INTO district (district_name, state_id) VALUES ('Thane', 14);
INSERT INTO district (district_name, state_id) VALUES ('Wardha', 14);
INSERT INTO district (district_name, state_id) VALUES ('Washim', 14);
INSERT INTO district (district_name, state_id) VALUES ('Yavatmal', 14);


INSERT INTO City (city_name, district_id) VALUES ('Nagpur', 21);
INSERT INTO City (city_name, district_id) VALUES ('Ramtek', 21);
INSERT INTO City (city_name, district_id) VALUES ('Umred', 21);
INSERT INTO City (city_name, district_id) VALUES ('Kalameshwar', 21);
INSERT INTO City (city_name, district_id) VALUES ('Katol', 21);
INSERT INTO City (city_name, district_id) VALUES ('Kamptee', 21);
INSERT INTO City (city_name, district_id) VALUES ('Kuhi', 21);
INSERT INTO City (city_name, district_id) VALUES ('Narkhed', 21);
INSERT INTO City (city_name, district_id) VALUES ('Bhiwapur', 21);
INSERT INTO City (city_name, district_id) VALUES ('Mouda', 21);
INSERT INTO City (city_name, district_id) VALUES ('Savner', 21);
INSERT INTO City (city_name, district_id) VALUES ('Hingna', 21);
INSERT INTO City (city_name, district_id) VALUES ('Parseoni', 21);
INSERT INTO City (city_name, district_id) VALUES ('Mandhal', 21);
INSERT INTO City (city_name, district_id) VALUES ('Sonegaon', 21);
INSERT INTO City (city_name, district_id) VALUES ('Tekadi', 21);
INSERT INTO City (city_name, district_id) VALUES ('Wadi', 21);
INSERT INTO City (city_name, district_id) VALUES ('Walani', 21);
INSERT INTO City (city_name, district_id) VALUES ('Yerkheda', 21);
