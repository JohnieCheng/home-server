package com.johnie.homeserver.service;

import com.johnie.homeserver.common.enums.JsonResult;
import com.johnie.homeserver.entity.SysUser;
import com.johnie.homeserver.pojo.dto.UserDTO;

public interface LoginService {
    JsonResult<SysUser> add(UserDTO userDTO);
}
