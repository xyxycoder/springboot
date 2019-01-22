package com.xiny.config.shiro;

import com.xiny.entity.User;
import com.xiny.service.UserService;
import com.xiny.sysConstant.SysConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MACBOOK on 2019/1/4.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

//    @Autowired
//    public void setUserService(UserService userService){
//        this.userService=userService;
//    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("+++++++++++++++++登陆验证");
        UsernamePasswordToken tokens = (UsernamePasswordToken) token;
        String username = (String) token.getPrincipal();
        ShiroUser user = userService.findByLoginName(username);
        // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
        if(user==null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(user.getPasswordSalt()),getName());

    }
}
