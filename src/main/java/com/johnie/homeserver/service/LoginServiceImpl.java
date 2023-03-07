package com.johnie.homeserver.service;

import com.johnie.homeserver.common.enums.JsonResult;
import com.johnie.homeserver.common.utils.ResultTool;
import com.johnie.homeserver.entity.SysUser;
import com.johnie.homeserver.pojo.dto.UserDTO;
import com.johnie.homeserver.pojo.vo.AddUserVo;
import com.johnie.homeserver.repository.LoginRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    final LoginRepository repository;

    public LoginServiceImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public JsonResult<SysUser> add(UserDTO userDTO) {
        SysUser sysUser = new SysUser(userDTO);
        SysUser user = repository.save(sysUser);
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.map(user, AddUserVo.class);
        return ResultTool.success(user);
    }
}
