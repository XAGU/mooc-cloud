package com.xagu.mooc.message.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Message implements Serializable {
    /**
    * 公告id
    */
    private Integer messageId;

    /**
    * 公告标题
    */
    private String messageName;

    /**
    * 公告内容
    */
    private String messageContent;

    /**
    * 发布时间
    */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}