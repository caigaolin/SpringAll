package com.topnet.mapper;

import com.topnet.model.Role;
import com.topnet.model.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Author cgl
 * @ClassName UserMapper
 * @Date Created in 16:09 2020/4/26
 */
public interface UserMapper extends MySqlMapper<User>, Mapper<User> {

    User loadUserByUsername(String username);

    List<Role> getRolesById(Integer id);

}
