package com.bankapplication.service;

import java.util.List;

import com.bankapplication.dto.ProfileUpdateDto;
import com.bankapplication.dto.RequestDto;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.model.Users;


public interface UserService {
    public RequestDto createuser(RequestDto requestDto);
    
//    public User getLoggedInUserDetails(String email);    
    
    public ResponseDto getLoggedInUserDetails(String email);
    
    
    public List<ResponseDto> findAllUser();
    
    public List<ResponseDto> findallInactiveUser();
    
    public Users getUserByEmail(String email);
    
    public ProfileUpdateDto convertToProfileUpdate(Users users);
}
