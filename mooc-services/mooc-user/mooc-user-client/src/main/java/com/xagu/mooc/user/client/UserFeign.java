package com.xagu.mooc.user.client;

import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.pojo.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xagu Created on 2020/6/6 Email:xagu_qc@foxmail.com Describe: 用户操作相关
 */
@Component
@FeignClient(name = "user-service", path = "api/user")
public interface UserFeign {


    /**
     * 插入新用户
     */
    @PostMapping
    public ResuBean insertUser(User user);

    /**
     * 根据条件查询所有
     *
     * @param user 参数可选，参数为空则查询所有
     */
    @GetMapping
    public ResuTable<List<User>> select(@SpringQueryMap PageDomain pageDomain, User user);

    /**
     * 更新用户数据
     */
    @PutMapping
    public ResuBean update(User user);

    /**
     * 批量删除用户
     *
     * @param ids 用户的id，逗号分隔
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable("ids") String ids);

    /**
     * 获取当前登录用户的所有菜单
     */
    @GetMapping("menus")
    public ResuTable<Power> getLoginUserPowers();

    /**
     * 获取当前登录用户个人信息
     */
    @GetMapping("myself")
    public ResuBean<User> getLoginUser();


    /**
     * 修改当前登录用户个人信息
     */
    @PutMapping("myself")
    public ResuBean updateMyself(@RequestParam("username") String username,
        @RequestParam("realName") String realName, @RequestParam("phoneNum") String phoneNum,
        @RequestParam("email") String email, @RequestParam("desc") String desc);

}
