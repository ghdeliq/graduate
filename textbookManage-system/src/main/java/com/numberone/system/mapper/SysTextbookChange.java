package com.numberone.system.mapper;

import java.util.List;

/**
 * 教材变更记录 数据层
 * @author guohui
 */
public interface SysTextbookChange {
    /**
     * 查询所有记录
     * @param
     * @return List<SysTextbookChange>
     */
    public List<SysTextbookChange> selectTextbookChanges();

    /**
     * 更新记录信息或状态
     * @param textbookChange
     * @return
     */
    public SysTextbookChange update(SysTextbookChange textbookChange);

    /**
     * 插入一条新记录
     * @param textbookChange
     * @return
     */
    public int insert(SysTextbookChange textbookChange);
}
