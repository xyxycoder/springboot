package com.xiny.service;

import com.xiny.config.shiro.ShiroUser;
import com.xiny.entity.User;
import com.xiny.vo.UserVo;

import java.util.List;

/**
 * Created by xiny on 2018/11/5.
 */
public interface UserService {


    ShiroUser findByLoginName(String username);

    int registerUser(UserVo vo);


}
