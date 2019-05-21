package com.numberone.system.mapper;

import com.numberone.system.domain.SysCourse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程 数据层
 * @author guohui
 */
@Component
public interface SysCourseMapper {
    /**
     * 查询所有课程
     * @param
     * @return List<SysCourse>
     */
    public List<SysCourse> selectCourses();

    /**
     * 查询在开设中的所有课程
     * @param
     * @return List<SysCourse>
     */
    public List<SysCourse> selectUseCourses();

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
    public int deleteByCourseIdSoft(Integer courseId);

    /**
     * 增加课程
     * @param course
     *
     */
    public int insertCourse(SysCourse course);

    /**
     * 批量课程信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
//    public int deleteCourseByIds(Integer[] ids);
}
