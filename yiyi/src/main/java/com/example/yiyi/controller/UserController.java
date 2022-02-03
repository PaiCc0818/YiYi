package com.example.yiyi.controller;

import com.example.yiyi.entity.User;
import com.example.yiyi.service.UserService;
import com.example.yiyi.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户表(User)表控制层
 *
 * @author 李二帅
 * @date 2022-01-02 12:29:04
 */
@Controller
@ResponseBody
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 用户token校验
     *
     * @param token token
     * @return 用户信息
     */
    @PostMapping("/checkToken")
    public Map<String, Object> validateToken(String token) {
        return JwtUtil.validateToken(token);
    }

    /**
     * 通过用户实体插入用户
     *
     * @param user 用户实体
     * @return 是否插入成功
     */
    @PostMapping("/insertUser")
    public boolean insert(User user) {
        return userService.insertUser(user);
    }
}