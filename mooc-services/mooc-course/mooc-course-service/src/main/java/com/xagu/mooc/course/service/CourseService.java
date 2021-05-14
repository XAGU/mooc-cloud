package com.xagu.mooc.course.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.pojo.Course;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseService{
        /**
         * 根据条件查询课程
         * @param pageDomain
         * @param course
         * @return
         */
        PageInfo<Course> selectByAll(PageDomain pageDomain, Course course);

        /**
         * 插入新的课程
         * @param course
         * @return
         */
        Boolean insertCourse(Course course);

        /**
         * 修改课程信息
         * @param course
         * @return
         */
        Boolean updateCourse(Course course);

        /**
         * 批量删除课程
         * @param ids
         * @return
         */
        Boolean batchDelete(String[] ids);

        /**
         * 浏览量加1
         * @param course
         * @return
         */
        Boolean updateCourseClick(Course course);

        /**
         * 根据科目Id查询课程
         * @param id
         * @return
         */
        List<Course> selectBySubjectId(Integer id);

        /**
         * 查询所有课程，包括科目信息
         * @param pageDomain
         * @return
         */
        PageInfo<Course> selectAllContainSubject(PageDomain pageDomain,Course course);

        /**
         * 查询课程按点击量排序
         * @return
         */
        PageInfo<Course> selectOrderByClick(PageDomain pageDomain);

        /**
         * 按创建者查询
         * @return
         */
        PageInfo<Course> selectByCreaterId(PageDomain pageDomain,Course course);
}
