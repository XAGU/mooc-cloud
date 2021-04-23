package com.xagu.mooc.user.service;

import com.xagu.mooc.user.vo.PowerOfRole;
import java.util.List;


/**
 * @author xagu
 */
public interface RolePowerService{


    /**
     * 修改角色拥有的权限
     * @param roleId
     * @param split
     * @return
     */
    Boolean updatePowerOfRole(Integer roleId, String[] split);

    /**
     * Describe: 获取角色权限
     * @param roleId
     * @return
     */
    List<PowerOfRole> getPowerOfRole(Integer roleId);
}
