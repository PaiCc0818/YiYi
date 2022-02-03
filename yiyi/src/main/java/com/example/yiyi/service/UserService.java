package com.example.yiyi.service;

import com.example.yiyi.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:04
 */
public interface UserService {
    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User queryUserByNickname(String username);

    /**
     * 通过用户实体插入用户
     *
     * @param user 用户实体
     * @return 是否插入成功
     */
    boolean insertUser(User user);
}
