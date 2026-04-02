package com.stu212306105.helloserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stu212306105.helloserver.common.Result;
import com.stu212306105.helloserver.common.ResultCode;
import com.stu212306105.helloserver.dto.UserDTO;
import com.stu212306105.helloserver.entity.User;
import com.stu212306105.helloserver.mapper.UserMapper;
import com.stu212306105.helloserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<String> register(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        User existUser = userMapper.selectOne(queryWrapper);

        if (existUser != null) {
            return Result.error(ResultCode.USER_HAS_EXISTED);
        }

        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

        userMapper.insert(newUser);

        return Result.success("注册成功");
    }

    @Override
    public Result<String> login(UserDTO userDTO) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDTO.getUsername());
        User dbUser = userMapper.selectOne(queryWrapper);

        if (dbUser == null) {
            return Result.error(ResultCode.USER_NOT_EXIST);
        }

        if (!dbUser.getPassword().equals(userDTO.getPassword())) {
            return Result.error(ResultCode.PASSWORD_ERROR);
        }

        String token = UUID.randomUUID().toString();
        return Result.success(token);
    }
}