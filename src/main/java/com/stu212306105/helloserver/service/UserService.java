package com.stu212306105.helloserver.service;

import com.stu212306105.helloserver.common.Result;
import com.stu212306105.helloserver.dto.UserDTO;

public interface UserService {
    Result<String> register(UserDTO userDTO);
    Result<String> login(UserDTO userDTO);
    Result<String> getUserById(Long id);

    Result<Object> getUserPage(Integer pageNum, Integer pageSize);
}