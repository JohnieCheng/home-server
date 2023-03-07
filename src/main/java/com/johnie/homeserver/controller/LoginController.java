package com.johnie.homeserver.controller;

import com.johnie.homeserver.common.enums.JsonResult;
import com.johnie.homeserver.entity.SysUser;
import com.johnie.homeserver.pojo.dto.UserDTO;
import com.johnie.homeserver.pojo.vo.AddUserVo;
import com.johnie.homeserver.service.LoginService;
import lombok.NonNull;
import org.dozer.DozerBeanMapper;
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
    public JsonResult<SysUser> addUser(@NonNull @RequestBody AddUserVo addUserVo) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        UserDTO userDTO = mapper.map(addUserVo, UserDTO.class);
        return this.loginService.add(userDTO);
    }
}
