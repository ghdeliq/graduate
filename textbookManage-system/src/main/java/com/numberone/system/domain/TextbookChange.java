package com.numberone.system.domain;


import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 教材变更记录表 sys_textbook_change
 * 
 * @author guohui
 * @date 2019-05-11
 */
public class TextbookChange extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 */
	private Integer tcId;
	/** 课程编号 */
	private Integer tcCourseId;
	/** 课程名 */
	private String courseName;
	/** 旧教材 */
	private String tcOldTextbook;
	/** 要更换的新教材 */
	private String tcNewTextbook;
	/** 新教材的价格 */
	private Double tcNewPrice;
	/** 申请人(教师工号） */
	private String tcChangeBy;
	/** 申请时间 */
	private Date tcUpTime;
	/** 审核人(管理员ID） */
	private String tcCheckBy;
	/** 审核时间 */
	private Date tcCheckTime;
	/** 当前审核状态(0：提交，待审核;1：通过;2：驳回) */
	private Integer tcState;

	public void setTcId(Integer tcId) 
	{
		this.tcId = tcId;
	}

	public Integer getTcId() 
	{
		return tcId;
	}
	public void setTcCourseId(Integer tcCourseId) 
	{
		this.tcCourseId = tcCourseId;
	}

	public Integer getTcCourseId() 
	{
		return tcCourseId;
	}
	public void setTcOldTextbook(String tcOldTextbook) 
	{
		this.tcOldTextbook = tcOldTextbook;
	}

	public String getTcOldTextbook() 
	{
		return tcOldTextbook;
	}
	public void setTcNewTextbook(String tcNewTextbook) 
	{
		this.tcNewTextbook = tcNewTextbook;
	}

	public String getTcNewTextbook() 
	{
		return tcNewTextbook;
	}
	public void setTcNewPrice(Double tcNewPrice) 
	{
		this.tcNewPrice = tcNewPrice;
	}

	public Double getTcNewPrice() 
	{
		return tcNewPrice;
	}
	public void setTcChangeBy(String tcChangeBy) 
	{
		this.tcChangeBy = tcChangeBy;
	}

	public String getTcChangeBy() 
	{
		return tcChangeBy;
	}
	public void setTcUpTime(Date tcUpTime) 
	{
		this.tcUpTime = tcUpTime;
	}

	public Date getTcUpTime() 
	{
		return tcUpTime;
	}
	public void setTcCheckBy(String tcCheckBy) 
	{
		this.tcCheckBy = tcCheckBy;
	}

	public String getTcCheckBy() 
	{
		return tcCheckBy;
	}
	public void setTcCheckTime(Date tcCheckTime) 
	{
		this.tcCheckTime = tcCheckTime;
	}

	public Date getTcCheckTime() 
	{
		return tcCheckTime;
	}
	public void setTcState(Integer tcState) 
	{
		this.tcState = tcState;
	}

	public Integer getTcState() 
	{
		return tcState;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tcId", getTcId())
            .append("tcCourseId", getTcCourseId())
            .append("tcOldTextbook", getTcOldTextbook())
            .append("tcNewTextbook", getTcNewTextbook())
            .append("tcNewPrice", getTcNewPrice())
            .append("tcChangeBy", getTcChangeBy())
            .append("tcUpTime", getTcUpTime())
            .append("tcCheckBy", getTcCheckBy())
            .append("tcCheckTime", getTcCheckTime())
            .append("tcState", getTcState())
            .toString();
    }
}
