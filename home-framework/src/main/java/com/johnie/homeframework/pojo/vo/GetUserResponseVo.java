package com.johnie.homeframework.pojo.vo;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class GetUserResponseVo {

    @Email
    private String email;
    @Length(min = 6, max = 15)
    private String password;


}
