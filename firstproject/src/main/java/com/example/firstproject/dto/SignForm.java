package com.example.firstproject.dto;

import com.example.firstproject.entity.Sign;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class SignForm {

    private String email;

    private String password;

    public Sign Entity(){
        return new Sign(null, email, password);
    }
}
