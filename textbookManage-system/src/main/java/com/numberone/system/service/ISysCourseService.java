package com.numberone.system.service;

import com.numberone.system.domain.SysCourse;

import java.util.List;

/**
 * 课程的相关操作 服务层
 * @author guohui
 */
public interface ISysCourseService {
    /**
     * 查询所有课程列表
     * （未删除的）
     */
    public List<SysCourse> selectCourses();

    /**
     * 查询所有在开设课程
     */
    public List<SysCourse> selectUseCourses();

    /**
     * 增加课程
     * @param course
     */
    public int insertCourse(SysCourse course);

    /**
     * 删除课程
     * （软删除）
     * @param courseId
     */
    public int deleteCourseByCourseId(Integer courseId);

    /**
     * 更换教材
     * @param course
     */
    public int changeTextbook(SysCourse course);

    /**
     * 根据课程Id获取教材信息
     * @param courseId
     * @return course
     */
    public SysCourse getCourseById(Integer courseId);

    /**
     * 批量删除角色用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
//    public int deleteCourseByIds(String ids) throws Exception;
}
