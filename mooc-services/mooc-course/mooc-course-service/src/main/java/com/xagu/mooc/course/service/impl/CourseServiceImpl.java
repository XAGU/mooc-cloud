package com.xagu.mooc.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.base.tools.DateUtils;
import com.xagu.mooc.course.mapper.CourseMapper;
import com.xagu.mooc.course.pojo.Course;
import com.xagu.mooc.course.service.CourseService;
import com.xagu.mooc.user.client.UserFeign;
import com.xagu.mooc.user.pojo.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/7 11:43
 */

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private UserFeign userFeign;

    @Resource
    private CourseMapper courseMapper;


    @Override
    public PageInfo<Course> selectByAll(PageDomain pageDomain, Course course) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Course>(courseMapper.selectByAll(course));
    }

    @Override
    public Boolean insertCourse(Course course) {
        //设置创建时间为当前时间
        course.setCreateTime(DateUtils.getNowDate());
        //判断是否设置了封面，没设置给默认路径值
        if (course.getCourseCover() == null || "".equals(course.getCourseCover())) {
            course.setCourseCover("https://unsplash.it/1000/450?image=116");
        }
        //设置点击量为0
        course.setCourseClick(0);

        User loginUser = userFeign.getLoginUser().getData();
        if (loginUser != null) {
            course.setCreaterId(loginUser.getUserId());
            //插入操作
            return courseMapper.insertCourse(course) > 0;
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateCourse(Course course) {
        return courseMapper.updateCourse(course) > 0;
    }

    @Override
    public Boolean batchDelete(String[] ids) {
        return courseMapper.batchDelete(ids) > 0;
    }

    @Override
    public Boolean updateCourseClick(Course course) {
        return courseMapper.updateCourseClick(course) > 0;
    }

    @Override
    public List<Course> selectBySubjectId(Integer id) {
        return courseMapper.selectBySubjectId(id);
    }

    @Override
    public PageInfo<Course> selectAllContainSubject(PageDomain pageDomain, Course course) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Course>(courseMapper.selectAllContainSubject(course));
    }

    @Override
    public PageInfo<Course> selectOrderByClick(PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Course>(courseMapper.selectOrderByClick());
    }

    @Override
    public PageInfo<Course> selectByCreaterId(PageDomain pageDomain, Course course) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        User loginUser = userFeign.getLoginUser().getData();
        if (loginUser != null) {
            course.setCreaterId(loginUser.getUserId());
            return new PageInfo<Course>(courseMapper.selectByCreaterId(course));
        } else {
            return null;
        }
    }

}
