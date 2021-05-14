package com.xagu.mooc.sign.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserSign implements Serializable {
    /**
    * 签到记录id
    */
    private Integer id;

    /**
    * 	用户id
    */
    private Integer userId;

    /**
    * 	签到id
    */
    private Integer signId;

    /**
    * 	签到时间
    */
    private Date signTime;

    private static final long serialVersionUID = 1L;
}