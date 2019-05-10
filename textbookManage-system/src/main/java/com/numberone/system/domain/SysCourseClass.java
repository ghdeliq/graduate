package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

/**
 * 课程-班级对应表
 * @author guohui
 */
public class SysCourseClass extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "编号")
    private Integer ccId;

    @Excel(name = "课程编号")
    private Integer courseId;

    @Excel(name = "班级编号(对应用户表里的dept_id)")
    private Integer classId;

    @Excel(name = "学期(2019春)")
    private String ccSemester;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getCcSemester() {
        return ccSemester;
    }

    public void setCcSemester(String ccSemester) {
        this.ccSemester = ccSemester;
    }

    @Override
    public String toString() {
        return "SysCourseClass{" +
                "ccId=" + ccId +
                ", courseId=" + courseId +
                ", classId=" + classId +
                ", ccSemester='" + ccSemester + '\'' +
                '}';
    }
}
