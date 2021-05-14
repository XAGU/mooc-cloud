package com.xagu.mooc.sign.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * nowtime>over_time即为未签到
    */
@Data
public class Sign implements Serializable {
    /**
    * 	签到id
    */
    private Integer signId;

    /**
    * 	课程
    */
    private Integer courseId;

    /**
    * 开始时间
    */
    private Date createTime;

    /**
    * 	结束时间
    */
    private Date overTime;

    private static final long serialVersionUID = 1L;
}