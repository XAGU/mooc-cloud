package com.xagu.mooc.base.domain.request;

import javax.validation.constraints.Min;
import lombok.Data;

/**
 * Describe: 分 页 参 数 封 装
 * Author: XAGU
 * CreateTime: 2019/10/23
 * */
@Data
public class PageDomain {

    /**
     * 当前页
     * */
    @Min(value = 0,message = "当前页需大于0")
    private Integer page;

    /**
     * 每页数量
     * */
    @Min(0)
    @Min(value = 0,message = "每页数量需大于0")
    private Integer limit;

}
