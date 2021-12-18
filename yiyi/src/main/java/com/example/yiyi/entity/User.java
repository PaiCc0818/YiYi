package com.example.yiyi.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author 李二帅
 * @since 2021-12-18 20:24:00
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 381095502509519044L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userNickname;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户头像
     */
    private String userHeadPortrait;
    /**
     * 创建时间
     */
    private Date userCreateTime;
    /**
     * 用户权限
     */
    private String userRights;
}
