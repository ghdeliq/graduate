package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

import java.sql.Timestamp;

/**
 * 学生预定教材表
 * @author guohui
 */
public class SysStuBookRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "编号")
    private Integer sbrId;

    @Excel(name = "学生学号")
    private String sbrStuId;

    @Excel(name = "课程编号")
    private Integer sbrCourseId;

    @Excel(name = "记录生成时间")
    private Timestamp sbrTime;

    public Integer getSbrId() {
        return sbrId;
    }

    public void setSbrId(Integer sbrId) {
        this.sbrId = sbrId;
    }

    public String getSbrStuId() {
        return sbrStuId;
    }

    public void setSbrStuId(String sbrStuId) {
        this.sbrStuId = sbrStuId;
    }

    public Integer getSbrCourseId() {
        return sbrCourseId;
    }

    public void setSbrCourseId(Integer sbrCourseId) {
        this.sbrCourseId = sbrCourseId;
    }

    public Timestamp getSbrTime() {
        return sbrTime;
    }

    public void setSbrTime(Timestamp sbrTime) {
        this.sbrTime = sbrTime;
    }

    @Override
    public String toString() {
        return "SysStuBookRecord{" +
                "sbrId=" + sbrId +
                ", sbrStuId='" + sbrStuId + '\'' +
                ", sbrCourseId=" + sbrCourseId +
                ", sbrTime=" + sbrTime +
                '}';
    }
}
