package com.xagu.mooc.user.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Power implements Serializable {
    /**
     * 权限id
     */
    private Integer powerId;

    /**
     * 权限名
     */
    private String powerName;

    /**
     * 权限类型
     */
    private Integer powerType;

    /**
     * 权限码
     */
    private String powerCode;

    /**
     * 权限的路径
     */
    private String powerUrl;

    /**
     * 权限状态
     */
    private Integer parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 权限状态
     */
    private Byte enable;

    private static final long serialVersionUID = 1L;
}