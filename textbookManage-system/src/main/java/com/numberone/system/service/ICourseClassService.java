package com.numberone.system.service;

import com.numberone.system.domain.CourseClass;
import java.util.List;

/**
 * 课程-班级对应 服务层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface ICourseClassService 
{
	/**
     * 查询课程-班级对应信息
     * 
     * @param ccId 课程-班级对应ID
     * @return 课程-班级对应信息
     */
	public CourseClass selectCourseClassById(Integer ccId);
	
	/**
     * 查询课程-班级对应列表
     * 
     * @param courseClass 课程-班级对应信息
     * @return 课程-班级对应集合
     */
	public List<CourseClass> selectCourseClassList(CourseClass courseClass);
	
	/**
     * 新增课程-班级对应
     * 
     * @param courseClass 课程-班级对应信息
     * @return 结果
     */
	public int insertCourseClass(CourseClass courseClass);
	
	/**
     * 修改课程-班级对应
     * 
     * @param courseClass 课程-班级对应信息
     * @return 结果
     */
	public int updateCourseClass(CourseClass courseClass);
		
	/**
     * 删除课程-班级对应信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCourseClassByIds(String ids);
	
}
