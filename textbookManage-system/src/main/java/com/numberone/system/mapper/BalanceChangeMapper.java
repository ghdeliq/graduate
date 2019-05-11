package com.numberone.system.mapper;

import com.numberone.system.domain.BalanceChange;

import java.util.Date;
import java.util.List;

/**
 * 学生余额变更 数据层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface BalanceChangeMapper 
{
	/**
     * 查询学生余额变更信息
     * 
     * @param createTime 学生余额变更ID
     * @return 学生余额变更信息
     */
	public BalanceChange selectBalanceChangeById(Date createTime);
	
	/**
     * 查询学生余额变更列表
     * 
     * @param balanceChange 学生余额变更信息
     * @return 学生余额变更集合
     */
	public List<BalanceChange> selectBalanceChangeList(BalanceChange balanceChange);
	
	/**
     * 新增学生余额变更
     * 
     * @param balanceChange 学生余额变更信息
     * @return 结果
     */
	public int insertBalanceChange(BalanceChange balanceChange);
	
	/**
     * 修改学生余额变更
     * 
     * @param balanceChange 学生余额变更信息
     * @return 结果
     */
	public int updateBalanceChange(BalanceChange balanceChange);
	
	/**
     * 删除学生余额变更
     * 
     * @param createTime 学生余额变更ID
     * @return 结果
     */
	public int deleteBalanceChangeById(Date createTime);
	
	/**
     * 批量删除学生余额变更
     * 
     * @param createTimes 需要删除的数据ID
     * @return 结果
     */
	public int deleteBalanceChangeByIds(String[] createTimes);
	
}