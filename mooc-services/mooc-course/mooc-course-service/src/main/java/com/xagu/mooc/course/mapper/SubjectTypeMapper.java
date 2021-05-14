package com.xagu.mooc.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.xagu.mooc.course.pojo.SubjectType;

import java.util.List;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface SubjectTypeMapper {

    /**
     * 根据条件查询
     *
     * @param subjectType
     * @return
     */
    List<SubjectType> selectByAll(SubjectType subjectType);

    /**
     * 添加科目
     *
     * @param subjectType
     * @return
     */
    int insertSubject(SubjectType subjectType);

    /**
     * 修改科目
     * @param subjectType
     * @return
     */
    int updateSubject(SubjectType subjectType);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteSubjects(String[] ids);
}