package com.xagu.mooc.user.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
     * 学生Id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 电话号码
     */
    private String phoneNum;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 学校名
     */
    private String schoolName;

    /**
     * 个人介绍
     */
    private String desc;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 0 冻结 1 正常
     */
    private Byte enable;

    /**
     * 用户的用户组
     */
    transient private Integer roleId;


    private static final long serialVersionUID = 1L;
}