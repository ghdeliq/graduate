package com.numberone.system.service;

import com.numberone.system.domain.StuBookRecord;
import java.util.List;

/**
 * 学生预定教材记录 服务层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface IStuBookRecordService 
{
	/**
     * 查询学生预定教材记录信息
     * 
     * @param sbrId 学生预定教材记录ID
     * @return 学生预定教材记录信息
     */
	public StuBookRecord selectStuBookRecordById(Integer sbrId);

	/**
	 * 查询学生预定教材记录信息
	 *
	 * @param sbrStuId 学生预定教材记录ID
	 * @return 学生预定教材记录信息
	 */
	public List<StuBookRecord> selectStuBookRecordByStuId(String sbrStuId);

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
     * 删除学生预定教材记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStuBookRecordByIds(String ids);

	/**
	 * 单条删除学生预定教材记录信息
	 *
	 * @param id 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteStuBookRecordById(Integer id);
}
