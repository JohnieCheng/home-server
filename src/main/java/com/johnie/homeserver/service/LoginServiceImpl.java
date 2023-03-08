package com.johnie.homeserver.service;

import com.johnie.homeserver.entity.SysUser;
import com.johnie.homeserver.framwork.Mappers.SysUserMapper;
import com.johnie.homeserver.framwork.enums.Result;
import com.johnie.homeserver.pojo.dto.UserDTO;
import com.johnie.homeserver.pojo.vo.AddUserResponseVo;
import com.johnie.homeserver.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    final LoginRepository repository;

    public LoginServiceImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<AddUserResponseVo> add(UserDTO userDTO) {
        SysUser sysUser = new SysUser(userDTO);
        SysUser user = repository.save(sysUser);
        AddUserResponseVo vo = SysUserMapper.SYS_USER_MAPPER.entity2vo(sysUser);
        return Result.ok(vo);
    }
}
