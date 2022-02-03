package com.example.yiyi.mapper;

import com.example.yiyi.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:04
 */
@Mapper
public interface UserMapper {
    /**
     * 通过用户名查询用户
     *
     * @param name 用户名
     * @return 用户信息
     */
    User queryUserByNickname(String name);

    /**
     * 通过用户实体插入用户
     *
     * @param user 用户实体
     * @return 是否插入成功
     */
    boolean insertUser(User user);
}

