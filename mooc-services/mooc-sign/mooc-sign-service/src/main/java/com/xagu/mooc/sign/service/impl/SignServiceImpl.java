package com.xagu.mooc.sign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.xagu.mooc.base.tools.DateUtils;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.sign.mapper.SignMapper;
import com.xagu.mooc.sign.pojo.Sign;
import com.xagu.mooc.sign.service.SignService;
@Service("signService")
public class SignServiceImpl implements SignService{

    @Resource
    private SignMapper signMapper;

    @Override
    public PageInfo<Sign> selectByAll(PageDomain pageDomain, Sign sign) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(signMapper.selectByAll(sign));
    }

    @Override
    public Boolean insertSign(Sign sign) {
        sign.setCreateTime(DateUtils.getNowDate());
        return signMapper.insertSign(sign)>0;
    }


    @Override
    public Boolean deleteById(String[] ids) {
        return signMapper.deleteById(ids)>0;
    }
}
