package com.xagu.mooc.user.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.ResuMenu;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.User;

import java.util.List;

public interface UserService {


    /**
     * 根据条件分页查询所有
     * @param pageDomain
     * @param user 查询的条件
     * @return
     */
    PageInfo<User> selectByAll(PageDomain pageDomain, User user);

    /**
     * 插入用户
     * @param user
     * @return
     */
    Boolean insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Boolean updateById(User user);


    /**
     * 批量删除
     * @param split
     * @return
     */
    Boolean batchDelete(String[] split);

    /**
     *
     * 获取当前登录用户的所有菜单
     * @return
     */
    List<ResuMenu> getLoginUserPowers();

    /**
     * 获取当前登录的用户
     * @return
     */
    User getLoginUser();

    /**
     * 修改当前登录用户个人信息
     * @return
     */
    Boolean updateMyself(String username, String realName, String phone, String email, String desc);
}

