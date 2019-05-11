package com.numberone.system.mapper;

import com.numberone.system.domain.StuBookRecord;
import java.util.List;	

/**
 * 学生预定教材记录 数据层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface StuBookRecordMapper 
{
	/**
     * 查询学生预定教材记录信息
     * 
     * @param sbrId 学生预定教材记录ID
     * @return 学生预定教材记录信息
     */
	public StuBookRecord selectStuBookRecordById(Integer sbrId);
	
	/**
     * 查询学生预定教材记录列表
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 学生预定教材记录集合
     */
	public List<StuBookRecord> selectStuBookRecordList(StuBookRecord stuBookRecord);
	
	/**
     * 新增学生预定教材记录
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 结果
     */
	public int insertStuBookRecord(StuBookRecord stuBookRecord);
	
	/**
     * 修改学生预定教材记录
     * 
     * @param stuBookRecord 学生预定教材记录信息
     * @return 结果
     */
	public int updateStuBookRecord(StuBookRecord stuBookRecord);
	
	/**
     * 删除学生预定教材记录
     * 
     * @param sbrId 学生预定教材记录ID
     * @return 结果
     */
	public int deleteStuBookRecordById(Integer sbrId);
	
	/**
     * 批量删除学生预定教材记录
     * 
     * @param sbrIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteStuBookRecordByIds(String[] sbrIds);
	
}