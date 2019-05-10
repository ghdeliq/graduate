package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

/**
 * 余额变更
 * @author guohui
 */
public class SysBalanceChange extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "流水ID")
    private Integer bcId;

    @Excel(name = "学生学号")
    private String stuId;

    @Excel(name = "课程编号")
    private Integer courseId;

    @Excel(name = "变更类型（0:订购，余额减少；1:取消，余额增加)")
    private Integer changeType;

    @Excel(name = "现阶段余额(允许负值)")
    private Double newBalance;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }

    public Double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Double newBalance) {
        this.newBalance = newBalance;
    }

    @Override
    public String toString() {
        return "SysBalanceChange{" +
                "bcId=" + bcId +
                ", stuId='" + stuId + '\'' +
                ", courseId=" + courseId +
                ", changeType=" + changeType +
                ", newBalance=" + newBalance +
                '}';
    }
}
