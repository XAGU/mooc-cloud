package com.xagu.mooc.practical.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.practical.pojo.Practical;
import com.xagu.mooc.practical.service.PracticalService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/practical")
public class PracticalController extends BaseController {

    @Resource
    private PracticalService practicalService;

    /**
     * 根据条件查询所有实训
     * @param pageDomain
     * @param practical
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Practical practical){
        PageInfo<Practical> practicalPageInfo = practicalService.selectByAll(pageDomain,practical);
        return pageTable(practicalPageInfo.getList(),practicalPageInfo.getTotal());
    }

    /**
     * 查询所有课程包括科目信息
     * @param pageDomain
     * @return
     */
    @GetMapping("/containSubject")
    public ResuTable selectAllContainSubject(PageDomain pageDomain,Practical practical){
        PageInfo<Practical> practicalPageInfo = practicalService.selectAllContainSubject(pageDomain,practical);
        return pageTable(practicalPageInfo.getList(),practicalPageInfo.getTotal());
    }

    /**
     * 插入新的实训
     * @param practical
     * @return
     */
    @PostMapping
    public ResuBean insertPractical(Practical practical){
        return decide(practicalService.insertPractical(practical),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改实训
     * @param practical
     * @return
     */
    @PutMapping
    public ResuBean updatePractical(Practical practical){
        return decide(practicalService.updatePractical(practical),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除实训
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deletePractical(@PathVariable String ids){
        return decide(practicalService.deletePractical(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

    /**
     * 浏览量加1
     * @param id
     * @return
     */
    @PutMapping("/addclick")
    public ResuBean updatePracticalClick(String id){
        return decide(practicalService.updatePracticalClick(id),
                MessageConstants.ADD_SUCCESS,
                MessageConstants.ADD_FAILURE);
    }

    /**
     * 根据subject_id查询实训
     * @param id
     * @return
     */
    @GetMapping("/practicalOfSubject/{id}")
    public ResuTable selectBySubjectId(@PathVariable Integer id){
        List<Practical> practicalList = practicalService.selectBySubjectId(id);
        return dataTable(practicalList);
    }

}
