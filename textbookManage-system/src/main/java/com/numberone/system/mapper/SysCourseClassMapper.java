package com.numberone.system.mapper;

import com.numberone.system.domain.SysCourseClass;

import java.util.List;

/**
 * 课程-班级对应表 数据层
 * @author guohui
 */
public interface SysCourseClassMapper {
    /**
     * 根据班级查课程
     * @param classId
     * @return List<SysCourseClass>
     */
    public List<SysCourseClass> selectByClassId(Integer classId);

    /**
     * 根据课程查班级
     * @param courseId
     * @return List<SysCourseClass>
     */
    public List<SysCourseClass> selectByCourseId(Integer courseId);
}
