package com.johnie.homeframework.service;


import com.johnie.homeframework.entity.SysUser;
import com.johnie.homeframework.framwork.Mappers.SysUserMapper;
import com.johnie.homeframework.framwork.enums.Result;
import com.johnie.homeframework.pojo.dto.UserDTO;
import com.johnie.homeframework.pojo.vo.AddUserResponseVo;
import com.johnie.homeframework.repository.LoginRepository;
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
        AddUserResponseVo vo = SysUserMapper.SYS_USER_MAPPER.entity2vo(user);
        return Result.ok(vo);
    }
}
