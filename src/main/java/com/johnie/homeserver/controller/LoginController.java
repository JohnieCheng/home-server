package com.johnie.homeserver.controller;

import com.johnie.homeserver.framwork.Mappers.SysUserMapper;
import com.johnie.homeserver.framwork.enums.Result;
import com.johnie.homeserver.pojo.dto.UserDTO;
import com.johnie.homeserver.pojo.vo.AddUserResponseVo;
import com.johnie.homeserver.pojo.vo.AddUserVo;
import com.johnie.homeserver.service.LoginService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Result<AddUserResponseVo> addUser(@NonNull @RequestBody AddUserVo addUserVo) {
        UserDTO userDTO = SysUserMapper.SYS_USER_MAPPER.vo2Dto(addUserVo);
        return this.loginService.add(userDTO);
    }
}
