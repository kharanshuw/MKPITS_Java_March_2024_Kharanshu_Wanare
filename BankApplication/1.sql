SELECT * FROM role 

SELECT * from users

SELECT * from userdetails

SELECT * from user_role

SELECT * from role;

INSERT INTO role(id,role_name) VALUES (1,'ROLE_ADMIN');

INSERT INTO role(id,role_name) VALUES (2,'ROLE_MANAGER');

INSERT INTO role(id,role_name) VALUES (3,'ROLE_USER');


    @Query("SELECT new com.bankapplication.dto.LoggesInUserDetails(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
            "FROM User u " +
            "INNER JOIN u.userDetails ud " +
            "JOIN u.role r " +
            "WHERE u.email = :email")
			
			
			SELECT u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename 
			from User u 
			INNER JOIN userDetails ud 
			ON u.id=ud.user_id
			INNER JOIN user_role ur 
			ON ur.user_id=u.id
			INNER role r 
			ON r.id=role_id
			
			@Query("SELECT new com.bankapplication.dto.ResponseDto(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
       "FROM User u " +
       "JOIN u.userDetails ud " +
       "JOIN u.role r")
	   
	   
	   @Query("SELECT new com.bankapplication.dto.ResponseDto(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
       "FROM User u " +
       "JOIN u.userDetails ud " +
       "JOIN u.role r")
		List<ResponseDto> findAllUserDetails();



INSERT INTO user_role(role_id,user_id) VALUES(3,9)


INSERT INTO state (state_name, state_code, country_id) VALUES 
('Andhra Pradesh', 37, 1),
('Arunachal Pradesh', 12, 1),
('Assam', 18, 1),
('Bihar', 10, 1),
('Chhattisgarh', 22, 1),
('Goa', 30, 1),
('Gujarat', 24, 1),
('Haryana', 06, 1),
('Himachal Pradesh', 02, 1),
('Jharkhand', 20, 1),
('Karnataka', 29, 1),
('Kerala', 32, 1),
('Madhya Pradesh', 23, 1),
('Maharashtra', 27, 1),
('Manipur', 14, 1),
('Meghalaya', 17, 1),
('Mizoram', 15, 1),
('Nagaland', 13, 1),
('Odisha', 21, 1),
('Punjab', 03, 1),
('Rajasthan', 08, 1),
('Sikkim', 11, 1),
('Tamil Nadu', 33, 1),
('Telangana', 36, 1),
('Tripura', 16, 1),
('Uttar Pradesh', 09, 1),
('Uttarakhand', 05, 1),
('West Bengal', 19, 1);

//endpoint to call location for testing
http://localhost:9191/api/countries

http://localhost:9191/api/states/1

http://localhost:9191/api/city/1

http://localhost:9191/api/district/1
