package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

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

    @Excel(name = "删除标志")
    private Boolean isDeleted;

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

    @Override
    public String toString() {
        return "SysCourse{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTextbook='" + courseTextbook + '\'' +
                ", textbookPrice=" + textbookPrice +
                ", courseType=" + courseType +
                ", courseUse=" + courseUse +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
