package com.xagu.mooc.user.mapper;

import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.vo.PowerOfRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PowerMapper {


    /**
     * 查询所有,参数可选
     *
     * @param power
     * @return
     */
    List<Power> selectByAll(Power power);


    /**
     * 查询所有,参数可选
     *
     * @return
     */
    List<PowerOfRole> selectPowerOfRole();

    /**
     * 插入权限
     *
     * @param power
     * @return
     */
    int insert(Power power);



    /**
     * 更新权限，传进来什么就更新什么
     *
     * @param power
     * @return
     */
    int updateById(Power power);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int batchDelete(String[] ids);

    /**
     * 根据用户的id查询用户的权限
     * @param userId
     * @return
     */
    List<Power> selectPowerByUserId(Integer userId);

}