package com.xagu.mooc.course.service;

import com.github.pagehelper.PageInfo;
import com.xagu.mooc.base.domain.request.PageDomain;
import com.xagu.mooc.course.pojo.SubjectType;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface SubjectTypeService{

        /**
         * 根据条件查询
         *
         * @param subjectType
         * @return
         */
        PageInfo<SubjectType> selectByAll(PageDomain pageDomain,SubjectType subjectType);

        /**
         * 新增科目
         *
         * @param subjectType
         * @return
         */
        Boolean insertSubject(SubjectType subjectType);

        /**
         * 修改科目
         *
         * @param subjectType
         * @return
         */
        Boolean updateSubject(SubjectType subjectType);

        /**
         * 批量删除
         *
         * @param ids
         * @return
         */
        Boolean deleteSubjects(String[] ids);
    }
