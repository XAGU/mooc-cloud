package com.xagu.mooc.user.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserRole implements Serializable {
    /**
    * 关联id

    */
    private Integer id;

    /**
    * 	用户id
    */
    @NonNull
    private Integer userId;

    /**
    * 	角色id
    */
    @NonNull
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}