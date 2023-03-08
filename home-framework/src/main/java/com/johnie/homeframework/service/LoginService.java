package com.johnie.homeframework.service;

import com.johnie.homeserver.framwork.enums.Result;
import com.johnie.homeserver.pojo.dto.UserDTO;
import com.johnie.homeserver.pojo.vo.AddUserResponseVo;

public interface LoginService {
    Result<AddUserResponseVo> add(UserDTO userDTO);
}
