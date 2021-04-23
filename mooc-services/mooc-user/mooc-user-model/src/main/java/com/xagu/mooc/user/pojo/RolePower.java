package com.xagu.mooc.user.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class RolePower implements Serializable {
    /**
    * 关联id
    */
    private Integer id;

    /**
    * 	角色id
    */
    private Integer roleId;

    /**
    * 权限id
    */
    private Integer powerId;

    private static final long serialVersionUID = 1L;
}