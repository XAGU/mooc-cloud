package com.xagu.mooc.sign.pojo;

import java.util.Date;
import lombok.Data;

@Data
public class UserCourseSign {
    /**
     * 	课程Id
     */
    private Integer courseId;

    /**
     * 	课程名
     */
    private String courseName;
    /**
     * 	签到时间
     */
    private Date signTime;
    /**
     * 	用户id
     */
    private Integer userId;
}
