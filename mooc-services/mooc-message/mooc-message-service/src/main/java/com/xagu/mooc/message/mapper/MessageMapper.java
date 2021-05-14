package com.xagu.mooc.message.mapper;

import com.xagu.mooc.message.pojo.Message;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 消息通知dao层
 */

@Mapper
public interface MessageMapper {
    /**
     * 根据条件查询所有
     * @param message
     * @return
     */
    List<Message> selectByAll(Message message);

    /**
     * 添加message
     * @param message
     * @return
     */
    int insertMessage(Message message);

    /**
     * 更新message
     * @param message
     * @return
     */
    int updateById(Message message);

    /**
     * 通过id删除message
     * @param ids
     * @return
     */
    int deleteById(String[] ids);
}