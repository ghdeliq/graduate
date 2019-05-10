package com.numberone.system.domain;

import com.numberone.common.annotation.Excel;
import com.numberone.common.base.BaseEntity;

import java.sql.Timestamp;

/***
 * 教材变更记录
 * @author guohui
 */
public class SysTextbookChange extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Excel(name = "记录编号")
    private Integer tcId;

    @Excel(name = "课程编号")
    private Integer tcCourseId;

    @Excel(name = "旧教材")
    private String tcOldTextbook;

    @Excel(name = "要更换的新教材")
    private String tcNewTextbook;

    @Excel(name = "新教材的价格")
    private Double tcNewPrice;

    @Excel(name = "申请人(教师工号）")
    private String tcChangeBy;

    @Excel(name = "申请时间")
    private Timestamp tcUpTime;

    @Excel(name = "审核人(管理员ID）")
    private String tcCheckBy;

    @Excel(name = "审核时间")
    private Timestamp tcCheckTime;

    @Excel(name = "当前审核状态(0：提交，待审核;1：通过;2：驳回)")
    private Integer tcState;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }

    public Integer getTcCourseId() {
        return tcCourseId;
    }

    public void setTcCourseId(Integer tcCourseId) {
        this.tcCourseId = tcCourseId;
    }

    public String getTcOldTextbook() {
        return tcOldTextbook;
    }

    public void setTcOldTextbook(String tcOldTextbook) {
        this.tcOldTextbook = tcOldTextbook;
    }

    public String getTcNewTextbook() {
        return tcNewTextbook;
    }

    public void setTcNewTextbook(String tcNewTextbook) {
        this.tcNewTextbook = tcNewTextbook;
    }

    public Double getTcNewPrice() {
        return tcNewPrice;
    }

    public void setTcNewPrice(Double tcNewPrice) {
        this.tcNewPrice = tcNewPrice;
    }

    public String getTcChangeBy() {
        return tcChangeBy;
    }

    public void setTcChangeBy(String tcChangeBy) {
        this.tcChangeBy = tcChangeBy;
    }

    public Timestamp getTcUpTime() {
        return tcUpTime;
    }

    public void setTcUpTime(Timestamp tcUpTime) {
        this.tcUpTime = tcUpTime;
    }

    public String getTcCheckBy() {
        return tcCheckBy;
    }

    public void setTcCheckBy(String tcCheckBy) {
        this.tcCheckBy = tcCheckBy;
    }

    public Timestamp getTcCheckTime() {
        return tcCheckTime;
    }

    public void setTcCheckTime(Timestamp tcCheckTime) {
        this.tcCheckTime = tcCheckTime;
    }

    public Integer getTcState() {
        return tcState;
    }

    public void setTcState(Integer tcState) {
        this.tcState = tcState;
    }

    @Override
    public String toString() {
        return "SysTextbookChange{" +
                "tcId=" + tcId +
                ", tcCourseId=" + tcCourseId +
                ", tcOldTextbook='" + tcOldTextbook + '\'' +
                ", tcNewTextbook='" + tcNewTextbook + '\'' +
                ", tcNewPrice=" + tcNewPrice +
                ", tcChangeBy='" + tcChangeBy + '\'' +
                ", tcUpTime=" + tcUpTime +
                ", tcCheckBy='" + tcCheckBy + '\'' +
                ", tcCheckTime=" + tcCheckTime +
                ", tcState=" + tcState +
                '}';
    }
}
