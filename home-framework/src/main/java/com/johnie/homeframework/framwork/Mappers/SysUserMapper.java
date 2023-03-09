package com.johnie.homeframework.framwork.Mappers;


import com.johnie.homeframework.entity.SysUser;
import com.johnie.homeframework.pojo.dto.UserDTO;
import com.johnie.homeframework.pojo.vo.AddUserResponseVo;
import com.johnie.homeframework.pojo.vo.AddUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserMapper {
    SysUserMapper SYS_USER_MAPPER = Mappers.getMapper(SysUserMapper.class);

    AddUserResponseVo entity2vo(SysUser sysUser);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    UserDTO vo2Dto(AddUserVo addUserVo);
}
