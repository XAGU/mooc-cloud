package com.xagu.mooc.user.mapper;
import com.xagu.mooc.user.pojo.Role;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xagu
 */
@Mapper
public interface RoleMapper {

    /**
     * 插入角色
     * @param record
     * @return
     */
    int insertRole(Role record);

    /**
     * 根据可选条件搜索
     * @param role
     * @return
     */
    List<Role> selectByAll(Role role);


    /**
     * 修改角色信息通过id
     * @param record
     * @return
     */
    int updateById(Role record);


    /**
     * 批量删除通过id
     * @param split
     * @return
     */
    int batchDelete(String[] split);
}