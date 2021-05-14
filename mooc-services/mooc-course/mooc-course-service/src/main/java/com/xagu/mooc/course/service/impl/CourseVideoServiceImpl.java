package com.xagu.mooc.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import com.xagu.mooc.base.tools.DateUtils;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.mapper.CourseVideoMapper;
import com.xagu.mooc.course.pojo.CourseVideo;
import com.xagu.mooc.course.service.CourseVideoService;

import javax.annotation.Resource;
import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseVideoServiceImpl implements CourseVideoService{

    @Resource
    CourseVideoMapper courseVideoMapper;

    @Override
    public PageInfo<CourseVideo> selectByAll(PageDomain pageDomain, CourseVideo courseVideo) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(courseVideoMapper.selectByAll(courseVideo));
    }

    @Override
    public Boolean insertVideo(CourseVideo courseVideo) {
        //设置创建时间为当前时间
        courseVideo.setCreateTime(DateUtils.getNowDate());
        return courseVideoMapper.insertVideo(courseVideo) > 0;
    }

    @Override
    public Boolean updateVideo(CourseVideo courseVideo) {
        return courseVideoMapper.updateVideo(courseVideo) > 0;
    }

    @Override
    public Boolean deleteVideos(String[] ids) {
        return courseVideoMapper.deleteVideos(ids) > 0;
    }

    @Override
    public List<CourseVideo> selectByMenuId(Integer id) {
        return courseVideoMapper.selectByMenuId(id);
    }
}
