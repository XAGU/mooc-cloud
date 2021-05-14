package com.xagu.mooc.sign.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.pojo.UserCourseSign;
import com.xagu.mooc.sign.pojo.UserSign;

public interface UserSignService{

    /**
     * 查询登录用户的签到信息
     * @param pageDomain
     * @return
     */
    PageInfo<UserCourseSign> selectByUser(PageDomain pageDomain, String courseId);

    /**
     * 用户签到
     * @param userSign
     * @return
     */
    Boolean insertUserSign(UserSign userSign);


    boolean batchDelete(String[] ids);
}
