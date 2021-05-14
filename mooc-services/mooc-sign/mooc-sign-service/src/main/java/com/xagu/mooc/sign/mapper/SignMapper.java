package com.xagu.mooc.sign.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.xagu.mooc.sign.pojo.Sign;

import java.util.List;

@Mapper
public interface SignMapper {

    /**
     * 查询 （可根据条件查询)
     * @param sign
     * @return
     */
    List<Sign> selectByAll(Sign sign);

    /**
     * 添加签到信息
     * @param sign
     * @return
     */
    int insertSign(Sign sign);


    /**
     * 删除签到
     * @param ids
     * @return
     */
    int deleteById(String[] ids);
}