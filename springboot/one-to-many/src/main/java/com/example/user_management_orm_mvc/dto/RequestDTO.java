package com.example.user_management_orm_mvc.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private String username;
    private String password;
    private String role;
    private String name;
    private String address;
    private String phoneNo;
    private String email;
}
