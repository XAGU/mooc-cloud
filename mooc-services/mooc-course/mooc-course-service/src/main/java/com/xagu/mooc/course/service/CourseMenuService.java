package com.xagu.mooc.course.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.pojo.CourseMenu;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseMenuService{

    /**
    * 根据条件查询目录
    * @param pageDomain
    * @param courseMenu
    * @return
    */
    PageInfo<CourseMenu> selectByAll(PageDomain pageDomain, CourseMenu courseMenu);

    /**
     * 添加目录
     * @param courseMenu
     * @return
     */
    Boolean insertMenu(CourseMenu courseMenu);

    /**
     * 修改目录
     * @param courseMenu
     * @return
     */
    Boolean updateMenu(CourseMenu courseMenu);

    /**
     * 删除目录
     * @param ids
     * @return
     */
    Boolean deleteMenus(String[] ids);

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    List<CourseMenu> selectByCourseId(Integer id,CourseMenu menu);
    }
