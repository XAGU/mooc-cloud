package com.xagu.mooc.sign.controller;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.pojo.UserCourseSign;
import com.xagu.mooc.sign.pojo.UserSign;
import com.xagu.mooc.sign.service.UserSignService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userSign")
public class UserSignController extends BaseController {

    @Resource
    private UserSignService userSignService;


    /**
     * 查询登录用户签到信息
     */
    @GetMapping
    public ResuTable selectByUser(PageDomain pageDomain,String courseId){
        PageInfo<UserCourseSign> userPageInfo = userSignService.selectByUser(pageDomain,courseId);
        return pageTable(userPageInfo.getList(),userPageInfo.getTotal());
    }

    /**
     * 用户签到
     * @param userSign
     * @return
     */
    @PostMapping
    public ResuBean insertUserSign(UserSign userSign){
        return decide(userSignService.insertUserSign(userSign),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 批量删除
     *
     * @param ids id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids){
        return decide(userSignService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
