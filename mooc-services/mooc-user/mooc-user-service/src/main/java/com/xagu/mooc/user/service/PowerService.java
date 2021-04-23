package com.xagu.mooc.user.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.Power;

public interface PowerService {

    /**
     * 根据条件分页查询所有
     * @param pageDomain
     * @param power
     * @return
     */
    PageInfo<Power> selectByAll(PageDomain pageDomain, Power power);

    /**
     * 插入新的权限
     * @param power
     * @return
     */
    Boolean insertPower(Power power);

    /**
     * 更新权限
     * @param power
     * @return
     */
    Boolean updateById(Power power);

    /**
     * 批量删除权限，逗号分隔
     * @param split
     * @return
     */
    Boolean batchDelete(String[] split);
}

