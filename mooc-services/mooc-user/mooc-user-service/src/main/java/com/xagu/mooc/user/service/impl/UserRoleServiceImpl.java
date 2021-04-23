package com.xagu.mooc.user.service.impl;

import com.xagu.mooc.user.mapper.UserRoleMapper;
import com.xagu.mooc.user.service.UserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;


}
