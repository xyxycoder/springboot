package com.xiny.controller;

import com.xiny.Exception.MyException;
import com.xiny.component.MailService;
import com.xiny.config.shiro.ShiroUser;
import com.xiny.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiny on 2018/11/5.
 */
@Controller
public class LoginController {


    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        if (shiroUser != null) {
            model.addObject("name", shiroUser.getUserName());
        }
        model.setViewName("index");
        return model;
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    /**
     * 注册页面
     *
     * @return
     */
    @GetMapping(value = "register")
    public String reg() {
        return "reg";
    }


    /**
     * 登陆方法
     *
     * @return
     */
    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> logins(@RequestBody Map<String, String> maps) {
        Map<String, Object> map = new HashMap<>();
        String userName = maps.get("userName").toString();
        if ("".equals(userName) || null == userName) {
            throw new MyException("404", "用户不能为空！");
        }
        String password = maps.get("password").toString();
        if ("".equals(password) || null == password) {
            throw new MyException("404", "密码不能为空！");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            throw new MyException("404", "用户或密码不正确！");
        }
        map.put("msg", "登陆成功！");
        map.put("code", 200);
        return map;
    }


    /**
     * 注销
     *
     * @return
     */
    @GetMapping("logout")
    public String logout() {
        System.out.println("+++++++++注销");
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }


}
