package com.xagu.mooc.course.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.mapper.SubjectTypeMapper;
import com.xagu.mooc.course.pojo.SubjectType;
import com.xagu.mooc.course.service.SubjectTypeService;
/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Resource
    private SubjectTypeMapper subjectTypeMapper;


    @Override
    public PageInfo<SubjectType> selectByAll(PageDomain pageDomain,SubjectType subjectType) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(subjectTypeMapper.selectByAll(subjectType));
    }

    @Override
    public Boolean insertSubject(SubjectType subjectType) {
        return subjectTypeMapper.insertSubject(subjectType) > 0;
    }

    @Override
    public Boolean updateSubject(SubjectType subjectType) {
        return subjectTypeMapper.updateSubject(subjectType) > 0;
    }

    @Override
    public Boolean deleteSubjects(String[] ids) {
        return subjectTypeMapper.deleteSubjects(ids) > 0;
    }
}
