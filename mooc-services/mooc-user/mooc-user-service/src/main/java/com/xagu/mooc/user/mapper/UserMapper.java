package com.xagu.mooc.user.mapper;
import com.xagu.mooc.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * User Mapper层
 * @author xagu
 */
@Mapper
public interface UserMapper {

    /**
     * 根据条件查询所有
     *
     * @param user
     * @return
     */
    List<User> selectByAll(User user);


    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(User user);


    /**
     * 根据条件修改用户
     * @param user
     * @return
     */
    int updateById(@Param("user") User user);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String[] ids);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User loadUserByUsername(@Param("username")String username);

    User selectOneByUserId(@Param("userId")Integer userId);

}