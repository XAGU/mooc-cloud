package com.xagu.mooc.user.controller;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.constant.MessageConstants;
import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.base.domain.ResuTable;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.pojo.Role;
import com.xagu.mooc.user.service.RoleService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xagu
 * Created on 2020/6/7
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@RestController
@RequestMapping("api/role")
public class RoleController extends BaseController {

    @Resource
    RoleService roleService;

    /**
     * 插入新角色
     *
     * @param role
     * @return
     */
    @PostMapping
    public ResuBean insertUser(Role role) {
        return decide(roleService.insertRole(role),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 根据条件查询角色
     *
     * @param pageDomain
     * @param role       参数可选，参数为空则查询所有
     * @return
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, Role role) {
        PageInfo<Role> userPageInfo = roleService.selectByAll(pageDomain, role);
        return pageTable(userPageInfo.getList(), userPageInfo.getTotal());
    }

    /**
     * 更新角色数据
     * @param role
     * @return
     */
    @PutMapping
    public ResuBean update(Role role) {
        return decide(roleService.updateById(role),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除角色
     * @param ids 角色的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(roleService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
