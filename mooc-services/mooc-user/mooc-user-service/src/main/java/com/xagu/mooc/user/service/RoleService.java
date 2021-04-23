package com.xagu.mooc.user.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.Role;

import java.util.List;
public interface RoleService{


    /**
     * 插入新角色
     * @param role
     * @return
     */
    Boolean insertRole(Role role);

    /**
     * 分页按条件查询角色
     * @param pageDomain
     * @param role
     * @return
     */
    PageInfo<Role> selectByAll(PageDomain pageDomain, Role role);

    /**
     * 修改权限信息
     * @param role
     * @return
     */
    Boolean updateById(Role role);

    /**
     * 批量删除角色信息
     * @param split
     * @return
     */
    Boolean batchDelete(String[] split);
}
