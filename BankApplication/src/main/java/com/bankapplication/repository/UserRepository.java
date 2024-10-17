package com.bankapplication.repository;

import com.bankapplication.dto.LoggesInUserDetails;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query("SELECT new com.bankapplication.dto.LoggesInUserDetails(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
            "FROM User u " +
            "INNER JOIN u.userDetails ud " +
            "JOIN u.role r " +
            "WHERE u.email = :email")
    public LoggesInUserDetails findUserRoleDetailsByEmail(@Param("email") String email);
    
    
//    
//    @Query("SELECT new com.bankapplication.dto.ResponseDto(u.id, u.email, ud.fname, ud.lname, ud.gender, ud.phoneno, r.rolename) " +
//    	       "FROM User u " +
//    	       "JOIN u.userDetails ud " +
//    	       "JOIN u.role r")
//    	public List<ResponseDto> findAllUserDetails();

    
}
