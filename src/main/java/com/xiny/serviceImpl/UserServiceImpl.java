package com.xiny.serviceImpl;

import com.xiny.config.shiro.ShiroUser;
import com.xiny.dao.UserMapper;
import com.xiny.entity.User;
import com.xiny.service.UserService;
import com.xiny.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiny on 2018/11/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ShiroUser findByLoginName(String username) {
        return userMapper.findByLoginName(username);
    }

    @Override
    public int registerUser(UserVo vo) {
        return userMapper.registerUser(vo);
    }

}
