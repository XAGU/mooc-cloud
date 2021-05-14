package com.xagu.mooc.course.pojo;

import java.io.Serializable;
import lombok.Data;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Data
public class SubjectType implements Serializable {
    /**
    * 分类id
    */
    private Integer subjectId;

    /**
    * 科目类别名
    */
    private String subjectName;

    private static final long serialVersionUID = 1L;
}