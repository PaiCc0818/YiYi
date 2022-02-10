package com.example.yiyi.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户表(User)实体类
 *
 * @author 李二帅
 * @since 2022-01-02 12:29:04
 */
@Data
public class User implements UserDetails {
    private static final long serialVersionUID = 599062697970252197L;
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
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户QQ
     */
    private String userQq;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(this::getUserRights);
        return auths;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userNickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
