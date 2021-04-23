package com.xagu.mooc.user.service.impl;

import com.xagu.mooc.user.mapper.PowerMapper;
import com.xagu.mooc.user.mapper.RolePowerMapper;
import com.xagu.mooc.user.pojo.RolePower;
import com.xagu.mooc.user.service.RolePowerService;
import com.xagu.mooc.user.vo.PowerOfRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service("rolePowerService")
public class RolePowerServiceImpl implements RolePowerService {

    @Resource
    private RolePowerMapper rolePowerMapper;

    @Resource
    private PowerMapper powerMapper;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean updatePowerOfRole(Integer roleId, String[] split) {
        //清空用户之前的权限
        rolePowerMapper.deletePowerByRoleId(roleId);
        //当传进来的权限id为空，就说明把某个角色的权限全部删除了
        if (split.length == 0) {
            //直接返回，不用插入了
            return true;
        }
        //将新权限加进去
        return rolePowerMapper.addPowerToRole(roleId, split) > 0;
    }

    @Override
    public List<PowerOfRole> getPowerOfRole(Integer roleId) {
        List<PowerOfRole> allPower = powerMapper.selectPowerOfRole();
        List<RolePower> myPower = rolePowerMapper.selectRolePowerByRoleId(roleId);
        allPower.forEach(power -> {
            myPower.forEach(sysRolePower -> {
                if (sysRolePower.getPowerId().equals(power.getPowerId())) {
                    power.setCheckArr("1");
                }
            });
        });
        return allPower;
    }
}
