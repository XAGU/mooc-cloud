package com.xagu.mooc.course.mapper;

import com.xagu.mooc.course.pojo.CourseVideo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface CourseVideoMapper {

    /**
     * 根据条件chaxun
     * @param courseVideo
     * @return
     */
    List<CourseVideo> selectByAll(CourseVideo courseVideo);

    /**
     * 新增视频
     * @param courseVideo
     * @return
     */
    int insertVideo(CourseVideo courseVideo);

    /**
     * 修改视频
     * @param courseVideo
     * @return
     */
    int updateVideo(CourseVideo courseVideo);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteVideos(String[] ids);

    /**
     * 根据目录id查视频
     * @param id
     * @return
     */
    List<CourseVideo> selectByMenuId(Integer id);
}