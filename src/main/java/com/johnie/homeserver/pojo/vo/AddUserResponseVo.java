package com.johnie.homeserver.pojo.vo;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class AddUserResponseVo {

    @Email
    private String email;
    @Length(min = 6, max = 15)
    private String password;


}
