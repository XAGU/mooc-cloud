package com.xagu.mooc.user.controller;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.User;
import com.xagu.mooc.user.service.UserService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xagu
 * Created on 2020/6/6
 * Email:xagu_qc@foxmail.com
 * Describe: 用户操作相关
 */
@RestController
@RequestMapping("api/user")
@Validated
public class UserController extends BaseController {


    @Resource
    UserService userService;


    /**
     * 插入新用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResuBean insertUser(User user) {
        return decide(userService.insertUser(user),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 根据条件查询所有
     *
     * @param pageDomain
     * @param user       参数可选，参数为空则查询所有
     * @return
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, User user) {
        PageInfo<User> userPageInfo = userService.selectByAll(pageDomain, user);
        return pageTable(userPageInfo.getList(), userPageInfo.getTotal());
    }

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    @PutMapping
    public ResuBean update(User user) {
        return decide(userService.updateById(user),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除用户
     *
     * @param ids 用户的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(userService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

    /**
     * 获取当前登录用户的所有菜单
     *
     * @return
     */
    @GetMapping("menus")
    public ResuTable getLoginUserPowers() {
        return dataTable(userService.getLoginUserPowers());
    }

    /**
     * 获取当前登录用户个人信息
     *
     * @return
     */
    @GetMapping("myself")
    public ResuBean getLoginUser() {
        User loginUser = userService.getLoginUser();
        return decide(loginUser != null,
                MessageConstants.SELECT_SUCCESS,
                MessageConstants.SELECT_FAILURE,
                loginUser);
    }


    /**
     * 修改当前登录用户个人信息
     *
     * @return
     */
    @PutMapping("myself")
    public ResuBean updateMyself(String username, String realName, String phoneNum, String email, String desc) {
        return decide(userService.updateMyself(username, realName, phoneNum, email, desc),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

}
