package com.numberone.system.mapper;

import com.numberone.system.domain.SysCourse;

import java.util.List;

/**
 * 课程 数据层
 * @author guohui
 */
public interface SysCourseMapper {
    /**
     * 查询所有课程
     * @param
     * @return List<SysCourse>
     */
    public List<SysCourse> selectCourses();

    /**
     * 根据课程编号获取课详细信息
     * @param courseId
     * @return SysCourse
     */
    public SysCourse selectCourseById(Integer courseId);

    /**
     * 修改课程的教材
     * @param course
     * @return
     */
    public int updateTextbookByCourseId(SysCourse course);

    /**
     * 删除课程（软删除）
     * @param courseId
     * @return int
     */
    public int deleteByCourseId(Integer courseId);

    /**
     * 增加课程
     * @param course
     *
     */
    public int insert(SysCourse course);
}
