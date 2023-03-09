package com.johnie.homeframework.controller;


import com.johnie.homeframework.framwork.Mappers.SysUserMapper;
import com.johnie.homeframework.framwork.enums.Result;
import com.johnie.homeframework.pojo.dto.UserDTO;
import com.johnie.homeframework.pojo.vo.AddUserResponseVo;
import com.johnie.homeframework.pojo.vo.AddUserVo;
import com.johnie.homeframework.service.LoginService;
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
