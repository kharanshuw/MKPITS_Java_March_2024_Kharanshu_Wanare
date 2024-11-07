package com.bankapplication.service;

import java.util.List;

import com.bankapplication.dto.ProfileUpdateDto;
import com.bankapplication.dto.RequestDto;
import com.bankapplication.dto.ResponseDto;
import com.bankapplication.model.User;


public interface UserService {
    public RequestDto createuser(RequestDto requestDto);
    
//    public User getLoggedInUserDetails(String email);    
    
    public ResponseDto getLoggedInUserDetails(String email);
    
    
    public List<ResponseDto> findAllUser();
    
    public List<ResponseDto> findallInactiveUser();
    
    public User getUserByEmail(String email);
    
    public ProfileUpdateDto convertToProfileUpdate(User user);
}
