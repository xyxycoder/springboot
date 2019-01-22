package com.xiny.controller;


import com.google.common.collect.Maps;
import com.xiny.service.UserService;
import com.xiny.sysConstant.SysConstant;
import com.xiny.util.RandomValidateCodeUtil;
import com.xiny.vo.UserVo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by xiny on 2019/1/3.
 */
@Controller
public class RegisteController {

    private static final Logger logger = LoggerFactory.getLogger(RegisteController.class);

    //随机数生成器(盐值)
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    //指定散列算法为md5
    private String algorithmName = "MD5";
    //散列迭代次数（次数越多越安全）
    private final int hashIterations = 1024;

    @Autowired
    private UserService userService;


    @PostMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
        public Map<String, Object> save(@RequestBody UserVo vo) {
        Map<String, Object> map= Maps.newHashMap();
        if (vo.getUserName() == null || vo.getUserName().equals("")) {
            throw new NullPointerException();
        }
        if (vo.getPassword() == null || vo.getPassword().equals("")) {
            throw new NullPointerException();
        }
        if (vo.getConfirmPassword() == null || vo.getConfirmPassword().equals("")) {
            throw new NullPointerException();
        }
        //验证两次密码相等
        if (!vo.getConfirmPassword().equals(vo.getPassword())) {
            throw new NullPointerException();
        }
        try {
            //盐值
            String salt = randomNumberGenerator.nextBytes().toHex();
            //md5加密
            String password = new SimpleHash(algorithmName, vo.getPassword(), ByteSource.Util.bytes(salt), hashIterations).toHex();
            vo.setPasswordSalt(salt);
            vo.setPassword(password);
            vo.setCreateDate(new Date());
            vo.setLastDate(new Date());
            vo.setIsLock(SysConstant.UNISLOCK_USER);
            vo.setDelFlag(SysConstant.UNDELFLAG_USE);
            int id=userService.registerUser(vo);
            System.out.println("新建用户ID:"+id);
            map.put("msg","注册成功");
        } catch (Exception e) {
            map.put("msg","注册失败");
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 生成验证码
     */
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }



}
