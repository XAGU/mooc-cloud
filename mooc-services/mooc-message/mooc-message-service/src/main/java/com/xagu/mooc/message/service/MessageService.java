package com.xagu.mooc.message.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.message.pojo.Message;

public interface MessageService{


    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param message
     * @return
     */
    PageInfo<Message> selectByAll(PageDomain pageDomain, Message message);

    /**
     * 添加message
     * @param message
     * @return
     */
    Boolean insertMessage(Message message);

    /**
     * 更新message
     * @param message
     * @return
     */
    Boolean updateMessageById(Message message);

    /**
     *通过id删除message
     * @param ids
     * @return
     */
    Boolean deleteMessageById(String[] ids);

}
