package com.xagu.mooc.sign.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.pojo.Sign;

public interface SignService{

    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param sign
     * @return
     */
    PageInfo<Sign> selectByAll(PageDomain pageDomain,Sign sign);

    /**
     * 添加签到信息
     * @param sign
     * @return
     */
    Boolean insertSign(Sign sign);


    /**
     * 删除签到信息
     * @param ids
     * @return
     */
    Boolean deleteById(String[] ids);
}
