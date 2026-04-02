package com.stu212306105.helloserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("sys_user") // 映射数据库的 sys_user 表
public class User {

    @TableId(type = IdType.AUTO) // 设置 id 为自增主键
    private Long id;

    private String username;
    private String password;

    // 无参构造函数（MyBatis-Plus 必须要求有这个）
    public User() {
    }

    // 全参构造函数
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters 和 Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}