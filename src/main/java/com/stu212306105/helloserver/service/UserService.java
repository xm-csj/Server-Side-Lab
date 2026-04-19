package com.stu212306105.helloserver.service;

import com.stu212306105.helloserver.common.Result;
import com.stu212306105.helloserver.dto.UserDTO;
import com.stu212306105.helloserver.entity.UserInfo;
import com.stu212306105.helloserver.vo.UserDetailVO;

public interface UserService {
    Result<String> register(UserDTO userDTO);
    Result<String> login(UserDTO userDTO);
    Result<String> getUserById(Long id);
    Result<Object> getUserPage(Integer pageNum, Integer pageSize);

    Result<UserDetailVO> getUserDetail(Long userId);
    Result<String> updateUserInfo(UserInfo userInfo);
    Result<String> deleteUser(Long userId);
}