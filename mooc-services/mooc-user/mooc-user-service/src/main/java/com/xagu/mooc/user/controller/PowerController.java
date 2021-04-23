package com.xagu.mooc.user.controller;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.service.PowerService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xagu
 * Created on 2020/6/8
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@RestController
@RequestMapping("api/power")
public class PowerController extends BaseController {

    @Resource
    private PowerService powerService;


    /**
     * 分页查询所有，参数条件可选
     *
     * @param pageDomain
     * @param power
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, Power power) {
        PageInfo<Power> powerPageInfo = powerService.selectByAll(pageDomain, power);
        return pageTable(powerPageInfo.getList(), powerPageInfo.getTotal());
    }

    /**
     * 插入新权限
     *
     * @param power
     * @return
     */
    @PostMapping
    public ResuBean insertUser(Power power) {
        return decide(powerService.insertPower(power),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }


    /**
     * 更新权限信息
     *
     * @param power
     * @return
     */
    @PutMapping
    public ResuBean update(Power power) {
        return decide(powerService.updateById(power),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除权限
     *
     * @param ids 权限的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(powerService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
