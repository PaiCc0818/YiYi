package com.example.yiyi.service.impl;

import com.example.yiyi.entity.User;
import com.example.yiyi.mapper.UserMapper;
import com.example.yiyi.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(User)表服务实现类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:04
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询用户通过用户名
     *
     * @param userNickname 用户名
     * @return 用户实体
     */
    @Override
    public User queryUserByNickname(String userNickname) {
        return this.userMapper.queryUserByNickname(userNickname);
    }

    /**
     * 通过用户实体插入用户
     *
     * @param user 用户实体
     * @return 是否插入成功
     */
    @Override
    public boolean insertUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        return this.userMapper.insertUser(user);
    }
}
