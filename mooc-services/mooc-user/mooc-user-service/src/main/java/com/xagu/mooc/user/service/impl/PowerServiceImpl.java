package com.xagu.mooc.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.user.mapper.PowerMapper;
import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.service.PowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("powerService")
public class PowerServiceImpl implements PowerService {

    @Resource
    private PowerMapper powerMapper;


    @Override
    public PageInfo<Power> selectByAll(PageDomain pageDomain, Power power) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<>(powerMapper.selectByAll(power));
    }

    @Override
    public Boolean insertPower(Power power) {
        return powerMapper.insert(power) > 0;
    }

    @Override
    public Boolean updateById(Power power) {
        return powerMapper.updateById(power) > 0;
    }

    @Override
    public Boolean batchDelete(String[] split) {
        return powerMapper.batchDelete(split) > 0;
    }


}

