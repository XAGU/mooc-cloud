package com.xagu.mooc.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.base.tools.DateUtils;
import com.xagu.mooc.user.mapper.RoleMapper;
import com.xagu.mooc.user.pojo.Role;
import com.xagu.mooc.user.service.RoleService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author xagu
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Boolean insertRole(Role role) {
        role.setCreateTime(DateUtils.getNowDate());
        return roleMapper.insertRole(role) > 0;
    }

    @Override
    public PageInfo<Role> selectByAll(PageDomain pageDomain, Role role) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Role>(roleMapper.selectByAll(role));
    }

    @Override
    public Boolean updateById(Role role) {
        return roleMapper.updateById(role) > 0;
    }

    @Override
    public Boolean batchDelete(String[] split) {
        return roleMapper.batchDelete(split) > 0;
    }
}
