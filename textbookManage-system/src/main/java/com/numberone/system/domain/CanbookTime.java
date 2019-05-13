package com.numberone.system.domain;


import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 时间控制表 sys_canbook_time
 * 
 * @author guohui
 * @date 2019-05-11
 */
public class CanbookTime extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer canId;
	/** 开始时间 */
	private Date canStart;
	/** 结束时间 */
	private Date canEnd;
	/** 是否使用 */
	private String canUse;
	/** 更新时间 */
	private Date canUpdateTime;
	/** 更新人 */
	private String canUpdateBy;
	/** 更新时间 */
	private Date createTime;
	/** 更新人 */
	private String createBy;
	/** 类型(0:订购教材时间; 1:教材更改时间) */
	private Integer canType;

	public void setCanId(Integer canId) 
	{
		this.canId = canId;
	}

	public Integer getCanId() 
	{
		return canId;
	}
	public void setCanStart(Date canStart) 
	{
		this.canStart = canStart;
	}

	public Date getCanStart() 
	{
		return canStart;
	}
	public void setCanEnd(Date canEnd) 
	{
		this.canEnd = canEnd;
	}

	public Date getCanEnd() 
	{
		return canEnd;
	}
	public void setCanUse(String canUse) 
	{
		this.canUse = canUse;
	}

	public String getCanUse() 
	{
		return canUse;
	}
	public void setCanUpdateTime(Date canUpdateTime) 
	{
		this.canUpdateTime = canUpdateTime;
	}

	public Date getCanUpdateTime() 
	{
		return canUpdateTime;
	}
	public void setCanUpdateBy(String canUpdateBy) 
	{
		this.canUpdateBy = canUpdateBy;
	}

	public String getCanUpdateBy() 
	{
		return canUpdateBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCanType(Integer canType) 
	{
		this.canType = canType;
	}

	public Integer getCanType() 
	{
		return canType;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("canId", getCanId())
            .append("canStart", getCanStart())
            .append("canEnd", getCanEnd())
            .append("canUse", getCanUse())
            .append("canUpdateTime", getCanUpdateTime())
            .append("canUpdateBy", getCanUpdateBy())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("canType", getCanType())
            .toString();
    }
}
