package com.bankapplication.service;

import java.util.List;

import com.bankapplication.dto.ResponseDto;
import com.bankapplication.model.User;

public interface AdminService {
    public String activateUser(String action,String id);
    
    public ResponseDto convertUserToResponseDto(User user);
    
    public List<String> findRole(String idString);
    
    public List<String> findUnassignedRoles(String userid);

    public String addRoleToUser(String rolename, String userid);
}
