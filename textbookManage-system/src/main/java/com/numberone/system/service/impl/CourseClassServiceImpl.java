package com.numberone.system.service.impl;

import java.util.List;

import com.numberone.system.domain.SysCourse;
import com.numberone.system.domain.SysDept;
import com.numberone.system.mapper.SysCourseMapper;
import com.numberone.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.system.mapper.CourseClassMapper;
import com.numberone.system.domain.CourseClass;
import com.numberone.system.service.ICourseClassService;
import com.numberone.common.support.Convert;

/**
 * 课程-班级对应 服务层实现
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Service
public class CourseClassServiceImpl implements ICourseClassService 
{
	@Autowired
	private CourseClassMapper courseClassMapper;

	@Autowired
	private SysCourseMapper courseMapper;

	@Autowired
	private SysDeptMapper deptMapper;

	/**
     * 查询课程-班级对应信息
     * 
     * @param ccId 课程-班级对应ID
     * @return 课程-班级对应信息
     */
    @Override
	public CourseClass selectCourseClassById(Integer ccId)
	{
	    return courseClassMapper.selectCourseClassById(ccId);
	}
	
	/**
     * 查询课程-班级对应列表
     * 
     * @param courseClass 课程-班级对应信息
     * @return 课程-班级对应集合
     */
	@Override
	public List<CourseClass> selectCourseClassList(CourseClass courseClass)
	{
		List<CourseClass> list = courseClassMapper.selectCourseClassList(courseClass);
		for (CourseClass cc : list) {
			SysCourse course = courseMapper.selectCourseById(cc.getCourseId());
			cc.setCourseName(course.getCourseName());
			SysDept dept = deptMapper.selectDeptById(cc.getClassId().longValue());
			cc.setClassName(dept.getDeptName());
		}
	    return list;
	}
	
    /**
     * 新增课程-班级对应
     * 
     * @param courseClass 课程-班级对应信息
     * @return 结果
     */
	@Override
	public int insertCourseClass(CourseClass courseClass)
	{
	    return courseClassMapper.insertCourseClass(courseClass);
	}
	
	/**
     * 修改课程-班级对应
     * 
     * @param courseClass 课程-班级对应信息
     * @return 结果
     */
	@Override
	public int updateCourseClass(CourseClass courseClass)
	{
	    return courseClassMapper.updateCourseClass(courseClass);
	}

	/**
     * 删除课程-班级对应对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCourseClassByIds(String ids)
	{
		return courseClassMapper.deleteCourseClassByIds(Convert.toStrArray(ids));
	}
	
}
