package com.xagu.mooc.user.mapper;
import com.xagu.mooc.user.pojo.RolePower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePowerMapper {

    /**
     * 根据角色id删除角色
     * @param roleId
     * @return
     */
    int deletePowerByRoleId(@Param("roleId")Integer roleId);


    /**
     * 给角色添加权限
     * @param roleId
     * @param split
     * @return
     */
    int addPowerToRole(@Param("roleId") Integer roleId,@Param("powerIds") String[] split);


    List<RolePower> selectRolePowerByRoleId(Integer roleId);


}