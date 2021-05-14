package com.xagu.mooc.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.pojo.Course;
import com.xagu.mooc.course.service.CourseService;

import java.util.List;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/7 12:26
 */
@RestController
@RequestMapping("api/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    /**
     * 根据条件查询课程
     * @param pageDomain
     * @param course
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Course course){
        PageInfo<Course> coursePageInfo = courseService.selectByAll(pageDomain,course);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }

    /**
     * 查询所有课程
     * @param pageDomain
     * @return
     */
    @GetMapping("/containSubject")
    public ResuTable selectAllContainSubject(PageDomain pageDomain,Course course){
        PageInfo<Course> coursePageInfo = courseService.selectAllContainSubject(pageDomain,course);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }

    /**
     * 根据科目Id查询课程
     * @param id
     * @return
     */
    @GetMapping("/courseOfSubject/{id}")
    public ResuTable selectBySubjectId(@PathVariable Integer id){
        List<Course> courseList = courseService.selectBySubjectId(id);
        return dataTable(courseList);
    }

    /**
     * 根据创建者Id查询课程
     * @param pageDomain
     * @param course
     * @return
     */
    @GetMapping("/courseOfCreater")
    public ResuTable selectByCreaterId(PageDomain pageDomain,Course course){
        PageInfo<Course> coursePageInfo = courseService.selectByCreaterId(pageDomain,course);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }

    /**
     * 按点击量排序
     * @param pageDomain
     * @return
     */
    @GetMapping("/courseOrderByClick")
    public ResuTable selectOrderByClick(PageDomain pageDomain){
        PageInfo<Course> coursePageInfo = courseService.selectOrderByClick(pageDomain);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }

    /**
     * 插入新的课程
     * @param course
     * @return
     */
    @PostMapping
    public ResuBean insertCourse(Course course){
        return decide(courseService.insertCourse(course),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @PutMapping
    public ResuBean updateCourse(Course course){
        return decide(courseService.updateCourse(course),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 删除课程
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids){
        return decide(courseService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

    /**
     * 浏览量加1
     * @param course
     * @return
     */
    @PutMapping("/addclick")
    public ResuBean updateCourseClick(Course course){
        return decide(courseService.updateCourseClick(course),
                MessageConstants.ADD_SUCCESS,
                MessageConstants.ADD_FAILURE);
    }
}
