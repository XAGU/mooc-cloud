package com.xagu.mooc.sign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xagu.mooc.user.client.UserFeign;
import com.xagu.mooc.user.pojo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.xagu.mooc.base.tools.DateUtils;
import com.xagu.mooc.base.tools.security.SecurityUtil;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.mapper.UserSignMapper;
import com.xagu.mooc.sign.pojo.UserCourseSign;
import com.xagu.mooc.sign.pojo.UserSign;
import com.xagu.mooc.sign.service.UserSignService;
@Service("userSignService")
public class UserSignServiceImpl implements UserSignService{

    @Resource
    private UserSignMapper userSignMapper;

    @Resource
    private UserFeign userFeign;

    @Override
    public PageInfo<UserCourseSign> selectByUser(PageDomain pageDomain, String courseId) {
        User loginUser = userFeign.getLoginUser().getData();
        if (loginUser != null) {
            int id = loginUser.getUserId();
            PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
            return new PageInfo<>(userSignMapper.selectByUser(courseId, id));
        }else {
            return null;
        }

    }

    @Override
    public Boolean insertUserSign(UserSign userSign) {
        userSign.setSignTime(DateUtils.getNowDate());
        return userSignMapper.insertUserSign(userSign)>0;
    }

    @Override
    public boolean batchDelete(String[] ids) {
        return userSignMapper.batchDelete(ids)>0;
    }
}
