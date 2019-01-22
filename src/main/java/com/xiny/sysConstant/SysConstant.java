package com.xiny.sysConstant;

/**
 * Created by xiny on 2018/11/5.
 * 系统常量
 */
public interface SysConstant {

    //用户session信息
    public static final String USERSESSION="user";

    //用户账号是否逻辑删除
    public static final String UNDELFLAG_USE="0";  //否

    public static final String DELFLAG_USE="1";  //是

    //用户被锁定，被禁止登录
    public static final String UNISLOCK_USER="0"; //否

    public static final String ISLOCK_USER="1";  //是
}
