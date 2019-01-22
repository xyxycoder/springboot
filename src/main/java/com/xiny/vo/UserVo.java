package com.xiny.vo;

import com.xiny.entity.User;

/**
 * Created by MACBOOK on 2019/1/16.
 */
public class UserVo extends User {

    private String  confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
