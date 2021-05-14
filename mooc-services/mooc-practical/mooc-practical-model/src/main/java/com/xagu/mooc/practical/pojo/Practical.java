package com.xagu.mooc.practical.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Practical implements Serializable {
    /**
    * 	实训方案id
    */
    private Integer practicalId;

    /**
        * 	方案名
    */
    private String practicalName;

    /**
    * 	方案封面
    */
    private String practicalCover;

    /**
     *科目类型,多课程对一科目
     */
    private SubjectType subjectType;

    /**
    * 	pdf方案链接
    */
    private String practicalUrl;

    /**
    * 	点击量
    */
    private Integer practicalClick;

    private static final long serialVersionUID = 1L;
}