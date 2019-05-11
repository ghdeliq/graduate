package com.numberone.system.domain;


import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 学生预定教材记录表 sys_stu_book_record
 * 
 * @author guohui
 * @date 2019-05-11
 */
public class StuBookRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer sbrId;
	/** 学生学号 */
	private String sbrStuId;
	/** 课程编号 */
	private Integer sbrCourseId;
	/** 记录生成时间 */
	private Date sbrTime;

	public void setSbrId(Integer sbrId) 
	{
		this.sbrId = sbrId;
	}

	public Integer getSbrId() 
	{
		return sbrId;
	}
	public void setSbrStuId(String sbrStuId) 
	{
		this.sbrStuId = sbrStuId;
	}

	public String getSbrStuId() 
	{
		return sbrStuId;
	}
	public void setSbrCourseId(Integer sbrCourseId) 
	{
		this.sbrCourseId = sbrCourseId;
	}

	public Integer getSbrCourseId() 
	{
		return sbrCourseId;
	}
	public void setSbrTime(Date sbrTime) 
	{
		this.sbrTime = sbrTime;
	}

	public Date getSbrTime() 
	{
		return sbrTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sbrId", getSbrId())
            .append("sbrStuId", getSbrStuId())
            .append("sbrCourseId", getSbrCourseId())
            .append("sbrTime", getSbrTime())
            .toString();
    }
}
