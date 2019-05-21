package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Timestamp;

public class SysCourse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "课程主键")
    private Integer courseId;

    @Excel(name = "课程名")
    private String courseName;

    @Excel(name = "课程使用教材")
    private String courseTextbook;

    @Excel(name = "教材价格")
    private Double textbookPrice;

    @Excel(name = "课程类型")
    private Integer courseType;

    @Excel(name = "是否开设")
    private Boolean courseUse;

    @Excel(name = "创建时间")
    private Timestamp createTime;

    @Excel(name = "更新时间")
    private Timestamp updateTime;

    @Excel(name = "更新流水号")
    private int updateTcId;

    @Excel(name = "删除标志")
    private Boolean isDeleted;

    private String stuBooked = "isnot";

    public String getStuBooked() {
        return stuBooked;
    }

    public void setStuBooked(String stuBooked) {
        this.stuBooked = stuBooked;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateTcId() {
        return updateTcId;
    }

    public void setUpdateTcId(int updateTcId) {
        this.updateTcId = updateTcId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTextbook() {
        return courseTextbook;
    }

    public void setCourseTextbook(String courseTextbook) {
        this.courseTextbook = courseTextbook;
    }

    public double getTextbookPrice() {
        return textbookPrice;
    }

    public void setTextbookPrice(double textbookPrice) {
        this.textbookPrice = textbookPrice;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Boolean getCourseUse() {
        return courseUse;
    }

    public void setCourseUse(Boolean courseUse) {
        this.courseUse = courseUse;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setTextbookPrice(Double textbookPrice) {
        this.textbookPrice = textbookPrice;
    }

    @Override
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("courseId=", getCourseId())
                .append("courseName=" , getCourseName())
                .append("courseTextbook=" , getCourseTextbook())
                .append("textbookPrice=" , getTextbookPrice())
                .append("courseType=" , getCourseUse())
                .append("courseUse=" , getCourseUse())
                .append("createTime=" , getCreateTime())
                .append("updateTcId=", getUpdateTcId())
                .append("updateTime=", getUpdateTime())
                .toString();

    }
}
