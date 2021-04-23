package com.xagu.mooc.base.domain;

import lombok.Data;

/**
 * Describe: Ajax 返回 JSON 结果封装数据
 * Author: XAGU
 * CreateTime: 2019/10/23
 * */

@Data
public class ResuBean {

    /**
     * 状态码
     * */
    private Integer code;

    /**
     * 提示消息
     * */
    private String msg;

    /**
     * 返回结果
     * */
    private boolean success;

    /**
     * 携带数据
     * */
    private Object data;

}
