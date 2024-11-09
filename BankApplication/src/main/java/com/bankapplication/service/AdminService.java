package com.bankapplication.service;

import java.util.List;

import com.bankapplication.dto.ProfileUpdateDto;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.model.User;

public interface AdminService {
    public String activateUser(String action,String id);
    
    public ResponseDto convertUserToResponseDto(User user);
    
    public List<String> findRole(String idString);
    
    public List<String> findUnassignedRoles(String userid);

    public String addRoleToUser(String rolename, String userid);

    public String removeRoleFromUser(String rolename, String userid);

    public User updateAdmin(ProfileUpdateDto profileUpdateDto);

    public int getIdByEmail(String email);

    public User getUserById(int id);
}
