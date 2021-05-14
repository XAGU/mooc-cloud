package com.xagu.mooc.practical.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.practical.pojo.Practical;

import java.util.List;

public interface PracticalService{

    /**
     * 根据条件查询所有实训方案
     * @param pageDomain
     * @param practical
     * @return
     */
    PageInfo<Practical> selectByAll(PageDomain pageDomain, Practical practical);

    /**
     * 查询所有方案，包括科目信息
     * @param pageDomain
     * @return
     */
    PageInfo<Practical> selectAllContainSubject(PageDomain pageDomain,Practical practical);

    /**
     * 插入新的实训
     * @param practical
     * @return
     */
    Boolean insertPractical(Practical practical);

    /**
     * 修改实训信息
     * @param practical
     * @return
     */
    Boolean updatePractical(Practical practical);

    /**
     * 批量删除实训
     * @param ids
     * @return
     */
    Boolean deletePractical(String[] ids);

    /**
     * 浏览量+1
     * @param id
     * @return
     */
    Boolean updatePracticalClick(String id);

    /**
     * 根据科目Id查询实训方案
     * @param id
     * @return
     */
    List<Practical> selectBySubjectId(Integer id);
}
