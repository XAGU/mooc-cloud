package com.xagu.mooc.course.pojo;

import java.io.Serializable;
import lombok.Data;
import com.xagu.mooc.user.pojo.User;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Data
public class CourseUser implements Serializable {

    /**
    * 课程id
    */
    private Integer courseId;

    /**
    * 用户id
    */
    private Integer userId;

    /**
     * 课程
     */
    private Course course;

    /**
     * 用户
     */
    private User user;

    private static final long serialVersionUID = 1L;
}