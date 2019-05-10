package com.numberone.system.mapper;

import com.numberone.system.domain.SysBalanceChange;

import java.util.List;

/**
 * 余额变更 数据层
 * @author guohui
 */
public interface SysBalanceChangeMapper {
    /**
     * 插入一条余额变更记录
     * @param balanceChange
     */
    public int insert(SysBalanceChange balanceChange);

    /**
     * 查询所有记录
     * @param
     * @return List<SysBalanceChange>
     */
    public List<SysBalanceChange> selectAll();

    /**
     * 查询某学生的订购记录
     * @param stuId
     * @return List<SysBalanceChange>
     */
    public List<SysBalanceChange> selectByStuId(String stuId);
}
