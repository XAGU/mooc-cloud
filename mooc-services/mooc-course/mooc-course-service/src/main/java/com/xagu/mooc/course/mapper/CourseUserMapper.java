package com.xagu.mooc.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xagu.mooc.course.pojo.Course;
import com.xagu.mooc.course.pojo.CourseUser;
import com.xagu.mooc.user.pojo.User;

import java.util.List;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface CourseUserMapper {

    /**
     * 通过用户查其参加的课程
     * @param id
     * @return
     */
    List<Course> selectCoursesByUser(Integer id);

    /**
     * 通过课程查用户
     * @param user
     * @return
     */
    List<User> selectUsersByCourse(@Param("id") Integer id, @Param("user") User user);

    /**
     * 给用户添加课程
     * @param courseUser
     * @return
     */
    int insertUserCourse(CourseUser courseUser);

    /**
     * 为用户删除课程
     * @param cId,sId
     * @return
     */
    int deleteUserCourse(@Param("cId") Integer cId,@Param("sId") Integer sId);
}