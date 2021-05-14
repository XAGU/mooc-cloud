package com.xagu.mooc.practical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.practical.mapper.PracticalMapper;
import com.xagu.mooc.practical.pojo.Practical;
import com.xagu.mooc.practical.service.PracticalService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XAGU
 */
@Service("practicalService")
public class PracticalServiceImpl implements PracticalService{

    @Resource
    private PracticalMapper practicalMapper;

    @Override
    public PageInfo<Practical> selectByAll(PageDomain pageDomain, Practical practical) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(practicalMapper.selectByAll(practical));
    }

    @Override
    public PageInfo<Practical> selectAllContainSubject(PageDomain pageDomain,Practical practical) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Practical>(practicalMapper.selectAllContainSubject(practical));
    }

    @Override
    public Boolean insertPractical(Practical practical) {
        //判断是否设置了封面，没设置给默认路径值
        if(practical.getPracticalCover() == null || "".equals(practical.getPracticalCover())){
            practical.setPracticalCover("https://unsplash.it/1000/450?image=116");
        }
        //设置点击量为0
        practical.setPracticalClick(0);
        //插入操作
        return practicalMapper.insertPractical(practical) > 0;
    }

    @Override
    public Boolean updatePractical(Practical practical) {
        return practicalMapper.updateByPractical(practical)>0;
    }

    @Override
    public Boolean deletePractical(String[] ids) {
        return practicalMapper.deleteById(ids)>0;
    }

    @Override
    public Boolean updatePracticalClick(String id) {
        return practicalMapper.updatePracticalClick(id) > 0;
    }

    @Override
    public List<Practical> selectBySubjectId(Integer id) {
        return practicalMapper.selectBySubjectId(id);
    }

}
