package com.xagu.mooc.sign.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.pojo.Sign;
import com.xagu.mooc.sign.service.SignService;

import javax.annotation.Resource;


@RestController
@RequestMapping("api/sign")
public class SignController extends BaseController {

    @Resource
    private SignService signService;

    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param sign
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Sign sign){
        System.out.println(pageDomain);
        System.out.println(sign);
        PageInfo<Sign> signPageInfo = signService.selectByAll(pageDomain,sign);
        return pageTable(signPageInfo.getList(),signPageInfo.getTotal());
    }

    /**
     * 添加签到信息
     * @param sign
     * @return
     */
    @PostMapping
    public ResuBean insertSign(Sign sign){
        return decide(signService.insertSign(sign),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }


    @DeleteMapping("{ids}")
    public ResuBean delete(@PathVariable String ids){
        System.out.println(ids);
        return decide(signService.deleteById(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
