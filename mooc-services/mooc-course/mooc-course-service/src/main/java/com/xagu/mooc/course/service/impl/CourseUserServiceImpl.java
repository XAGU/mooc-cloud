package com.xagu.mooc.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.base.tools.security.SecurityUtil;
import com.xagu.mooc.course.mapper.CourseUserMapper;
import com.xagu.mooc.course.pojo.Course;
import com.xagu.mooc.course.pojo.CourseUser;
import com.xagu.mooc.course.service.CourseUserService;
import com.xagu.mooc.user.client.UserFeign;
import com.xagu.mooc.user.pojo.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseUserServiceImpl implements CourseUserService{

    @Resource
    private UserFeign userFeign;

    @Resource
    private CourseUserMapper courseUserMapper;


    @Override
    public List<Course> getCoursesByUserId(Integer id) {
        return courseUserMapper.selectCoursesByUser(id);
    }

    @Override
    public PageInfo<User> getUsersByCourseId(PageDomain pageDomain,Integer id, User user) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<>(courseUserMapper.selectUsersByCourse(id,user));
    }

    @Override
    public Boolean insertUserCourse(CourseUser courseUser) {
        return courseUserMapper.insertUserCourse(courseUser) > 0;
    }

    @Override
    public Boolean deleteUserCourse(Integer cId,Integer sId) {
        return courseUserMapper.deleteUserCourse(cId,sId) > 0;
    }

    @Override
    public List<Course> getCoursesByNowUserId() {
        String loginUsername =  SecurityUtil.getLoginUser();
        if (StringUtils.isEmpty(loginUsername)) {
            return null;
        }
        User loginUser = userFeign.getLoginUser().getData();
        if (loginUser != null) {
            int id = loginUser.getUserId();
            return courseUserMapper.selectCoursesByUser(id);
        }else {
            return null;
        }
    }
}
