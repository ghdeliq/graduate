package com.numberone.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.system.mapper.StuBookRecordMapper;
import com.numberone.system.domain.StuBookRecord;
import com.numberone.system.service.IStuBookRecordService;
import com.numberone.common.support.Convert;

/**
 * 学生预定教材记录 服务层实现
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Service
public class StuBookRecordServiceImpl implements IStuBookRecordService 
{
	@Autowired
	private StuBookRecordMapper stuBookRecordMapper;

	/**
     * 查询学生预定教材记录信息
     * 
     * @param sbrId 学生预定教材记录ID
     * @return 学生预定教材记录信息
     */
    @Override
	public StuBookRecord selectStuBookRecordById(Integer sbrId)
	{
	    return stuBookRecordMapper.selectStuBookRecordById(sbrId);
	}
	
	/**
     * 查询学生预定教材记录列表
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 学生预定教材记录集合
     */
	@Override
	public List<StuBookRecord> selectStuBookRecordList(StuBookRecord stuBookRecord)
	{
	    return stuBookRecordMapper.selectStuBookRecordList(stuBookRecord);
	}
	
    /**
     * 新增学生预定教材记录
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 结果
     */
	@Override
	public int insertStuBookRecord(StuBookRecord stuBookRecord)
	{
	    return stuBookRecordMapper.insertStuBookRecord(stuBookRecord);
	}
	
	/**
     * 修改学生预定教材记录
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 结果
     */
	@Override
	public int updateStuBookRecord(StuBookRecord stuBookRecord)
	{
	    return stuBookRecordMapper.updateStuBookRecord(stuBookRecord);
	}

	/**
     * 删除学生预定教材记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStuBookRecordByIds(String ids)
	{
		return stuBookRecordMapper.deleteStuBookRecordByIds(Convert.toStrArray(ids));
	}
	
}
