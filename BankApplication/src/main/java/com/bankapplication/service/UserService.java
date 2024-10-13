package com.bankapplication.service;

import com.bankapplication.dto.RequestDto;
import com.bankapplication.model.User;


public interface UserService {
    public RequestDto createuser(RequestDto requestDto);
    
    
    public User getuserdetails();
}
