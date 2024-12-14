package com.example.user_service.model;


import lombok.Data;

@Data
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;


}
