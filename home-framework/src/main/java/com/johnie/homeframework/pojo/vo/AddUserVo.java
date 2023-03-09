package com.johnie.homeframework.pojo.vo;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class AddUserVo {

    @Email
    private String email;
    @Length(min = 6, max = 15)
    private String password;


}
