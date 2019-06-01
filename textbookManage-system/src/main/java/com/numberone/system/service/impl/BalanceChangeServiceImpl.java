package com.numberone.system.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.system.mapper.BalanceChangeMapper;
import com.numberone.system.domain.BalanceChange;
import com.numberone.system.service.IBalanceChangeService;
import com.numberone.common.support.Convert;

/**
 * 学生余额变更 服务层实现
 * 
 * @author guohui
 *
 * @date 2019-05-11
 */
@Service
public class BalanceChangeServiceImpl implements IBalanceChangeService 
{
	@Autowired
	private BalanceChangeMapper balanceChangeMapper;

	/**
     * 查询学生余额变更信息
     * 
     * @param createTime 学生余额变更ID
     * @return 学生余额变更信息
     */
    @Override
	public BalanceChange selectBalanceChangeById(Date createTime)
	{
	    return balanceChangeMapper.selectBalanceChangeById(createTime);
	}
	
	/**
     * 查询学生余额变更列表
     * 
     * @param balanceChange 学生余额变更信息
     * @return 学生余额变更集合
     */
	@Override
	public List<BalanceChange> selectBalanceChangeList(BalanceChange balanceChange)
	{
	    return balanceChangeMapper.selectBalanceChangeList(balanceChange);
	}
	
    /**
     * 新增学生余额变更
     * 
     * @param balanceChange 学生余额变更信息
     * @return 结果
     */
	@Override
	public int insertBalanceChange(BalanceChange balanceChange)
	{
	    return balanceChangeMapper.insertBalanceChange(balanceChange);
	}
	
	/**
     * 修改学生余额变更
     * 
     * @param balanceChange 学生余额变更信息
     * @return 结果
     */
	@Override
	public int updateBalanceChange(BalanceChange balanceChange)
	{
	    return balanceChangeMapper.updateBalanceChange(balanceChange);
	}

	/**
     * 删除学生余额变更对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBalanceChangeByIds(String ids)
	{
		return balanceChangeMapper.deleteBalanceChangeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询某学生余额变更记录
	 * 按时间排序
	 *
	 * @param stuId
	 */
	@Override
	public List<BalanceChange> selectBalanceChangesByStuId(String stuId) {

		return balanceChangeMapper.selectBalanceChangesByStuId(stuId);
	}
}
