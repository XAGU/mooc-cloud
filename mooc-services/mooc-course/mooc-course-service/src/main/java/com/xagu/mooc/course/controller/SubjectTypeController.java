package com.xagu.mooc.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.pojo.SubjectType;
import com.xagu.mooc.course.service.SubjectTypeService;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/8 22:56
 */
@RestController
@RequestMapping("api/subject")
public class SubjectTypeController extends BaseController {

    @Autowired
    SubjectTypeService subjectTypeService;

    /**
     * 根据条件查询
     * @param pageDomain
     * @param subjectType
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, SubjectType subjectType){
        PageInfo<SubjectType> subjectPageInfo = subjectTypeService.selectByAll(pageDomain,subjectType);
        return pageTable(subjectPageInfo.getList(),subjectPageInfo.getTotal());
    }

    /**
     * 新增科目
     * @param subjectType
     * @return
     */
    @PostMapping
    public ResuBean insertSubject(SubjectType subjectType){
        return decide(subjectTypeService.insertSubject(subjectType),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改科目
     * @param subjectType
     * @return
     */
    @PutMapping
    public ResuBean updateSubject(SubjectType subjectType){
        return decide(subjectTypeService.updateSubject(subjectType),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deleteSubjects(@PathVariable String[] ids){
        return decide(subjectTypeService.deleteSubjects(ids),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
