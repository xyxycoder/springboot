package com.xiny.dao;

import com.xiny.config.shiro.ShiroUser;
import com.xiny.entity.User;
import com.xiny.vo.UserVo;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    ShiroUser findByLoginName(String username);

    int registerUser(UserVo vo);

}