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
