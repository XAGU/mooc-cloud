package com.xagu.mooc.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.mapper.CourseMenuMapper;
import com.xagu.mooc.course.pojo.CourseMenu;
import com.xagu.mooc.course.service.CourseMenuService;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseMenuServiceImpl implements CourseMenuService{

    @Resource
    private CourseMenuMapper courseMenuMapper;

    @Override
    public PageInfo<CourseMenu> selectByAll(PageDomain pageDomain, CourseMenu courseMenu) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(courseMenuMapper.selectByAll(courseMenu));
    }

    @Override
    public Boolean insertMenu(CourseMenu courseMenu) {
        return courseMenuMapper.insertMenu(courseMenu) > 0;
    }

    @Override
    public Boolean updateMenu(CourseMenu courseMenu) {
        return courseMenuMapper.updateMenu(courseMenu) > 0;
    }

    @Override
    public Boolean deleteMenus(String[] ids) {
        return courseMenuMapper.deleteMenus(ids) > 0;
    }

    @Override
    public List<CourseMenu> selectByCourseId(Integer id,CourseMenu menu) {
        return courseMenuMapper.selectByCourseId(id,menu);
    }

}
