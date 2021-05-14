package com.xagu.mooc.message.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.message.pojo.Message;
import com.xagu.mooc.message.service.MessageService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/7
 * Email:xagu_qc@foxmail.com
 * Describe: 通知
 */
@RestController
@RequestMapping("api/message")
public class MessageController extends BaseController {

    @Resource
    private MessageService messageService;

    /**
     * 根据条件查询所有
     *
     * @param message
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Message message) {
        PageInfo<Message> messagePageInfo = messageService.selectByAll(pageDomain, message);
        return pageTable(messagePageInfo.getList(),messagePageInfo.getTotal());
    }

    /**
     * 添加消息
     * @param message
     * @return
     */
    @PostMapping
    public ResuBean insertMessage(Message message){
        return decide(messageService.insertMessage(message),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 更新message
     * @param message
     * @return
     */
    @PutMapping
    public ResuBean updateMessage(Message message){
        System.out.println(message);
        return decide(messageService.updateMessageById(message),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 通过id删除message
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deleteMessage(@PathVariable String ids){
        return decide(messageService.deleteMessageById(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
