package com.xagu.mooc.base.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describe: 前端表格数据封装
 * Author: XAGU
 * CreateTime: 2019/10/23
 * */

@Data
@EqualsAndHashCode()
public class ResuTable<T> {

    public interface JsonResuTable{};

    /**
     * 状态码
     * */
    private Integer code;


    /**
     * 消息总量
     * */
//    @JsonView(JsonResuTable.class)
    private Long count;

    /**
     * 数据对象
     * */
//    @JsonView(JsonResuTable.class)
    private T data;

}
