package com.johnie.homeframework.service;


import com.johnie.homeframework.framwork.enums.Result;
import com.johnie.homeframework.pojo.dto.UserDTO;
import com.johnie.homeframework.pojo.vo.AddUserResponseVo;

public interface LoginService {
    Result<AddUserResponseVo> add(UserDTO userDTO);
}
