package com.numberone.system.domain;


import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 学生余额变更表 sys_balance_change
 * 
 * @author guohui
 * @date 2019-05-11
 */
public class BalanceChange extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 流水生成时间 */
	private Date createTime;
	/** 流水ID */
	private Integer bcId;
	/** 学生学号 */
	private String stuId;
	/** 课程编号 */
	private Integer courseId;
	/** 变更类型（0:订购，余额减少；1:取消，余额增加) */
	private Integer changeType;
	/** 现阶段余额(允许负值) */
	private Double newBalance;
	/** 操作人 */
	private String createBy;

	/** 管理员 操作余额变更过渡值 */
	private Double newBalanceAdmin;

	public Double getNewBalanceAdmin() {
		return newBalanceAdmin;
	}

	public void setNewBalanceAdmin(Double newBalanceAdmin) {
		this.newBalanceAdmin = newBalanceAdmin;
	}

	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setBcId(Integer bcId) 
	{
		this.bcId = bcId;
	}

	public Integer getBcId() 
	{
		return bcId;
	}
	public void setStuId(String stuId) 
	{
		this.stuId = stuId;
	}

	public String getStuId() 
	{
		return stuId;
	}
	public void setCourseId(Integer courseId) 
	{
		this.courseId = courseId;
	}

	public Integer getCourseId() 
	{
		return courseId;
	}
	public void setChangeType(Integer changeType) 
	{
		this.changeType = changeType;
	}

	public Integer getChangeType() 
	{
		return changeType;
	}
	public void setNewBalance(Double newBalance) 
	{
		this.newBalance = newBalance;
	}

	public Double getNewBalance() 
	{
		return newBalance;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("createTime", getCreateTime())
            .append("bcId", getBcId())
            .append("stuId", getStuId())
            .append("courseId", getCourseId())
            .append("changeType", getChangeType())
            .append("newBalance", getNewBalance())
            .toString();
    }
}
