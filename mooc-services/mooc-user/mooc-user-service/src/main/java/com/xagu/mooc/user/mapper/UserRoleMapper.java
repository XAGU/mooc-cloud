package com.xagu.mooc.user.mapper;

import com.xagu.mooc.user.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    /**
     * 插入
     * @param userRole
     * @return
     */
    int insert(UserRole userRole);


    /**
     * 删除用户的角色信息
     * @param userId
     * @return
     */
    boolean deleteByUserId(Integer userId);
}