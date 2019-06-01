package com.numberone.system.domain;


import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程-班级对应表 sys_course_class
 * 
 * @author guohui
 * @date 2019-05-11
 */
public class CourseClass extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer ccId;
	/** 课程编号 */
	private Integer courseId;
	/** 班级编号(对应用户表里的dept_id) */
	private Integer classId;
	/** 学期(2019春) */
	private String ccSemester;

	/** 添加 课程名**/
	private String courseName;
	/** 添加 班级名**/
	private String className;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setCcId(Integer ccId)
	{
		this.ccId = ccId;
	}

	public Integer getCcId() 
	{
		return ccId;
	}
	public void setCourseId(Integer courseId) 
	{
		this.courseId = courseId;
	}

	public Integer getCourseId() 
	{
		return courseId;
	}
	public void setClassId(Integer classId) 
	{
		this.classId = classId;
	}

	public Integer getClassId() 
	{
		return classId;
	}
	public void setCcSemester(String ccSemester) 
	{
		this.ccSemester = ccSemester;
	}

	public String getCcSemester() 
	{
		return ccSemester;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ccId", getCcId())
            .append("courseId", getCourseId())
            .append("classId", getClassId())
            .append("ccSemester", getCcSemester())
            .toString();
    }
}
