package com.stu212306105.helloserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stu212306105.helloserver.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}