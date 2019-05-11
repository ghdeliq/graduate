package com.numberone.system.service;

import com.numberone.system.domain.TextbookChange;
import java.util.List;

/**
 * 教材变更记录 服务层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface ITextbookChangeService 
{
	/**
     * 查询教材变更记录信息
     * 
     * @param tcId 教材变更记录ID
     * @return 教材变更记录信息
     */
	public TextbookChange selectTextbookChangeById(Integer tcId);
	
	/**
     * 查询教材变更记录列表
     * 
     * @param textbookChange 教材变更记录信息
     * @return 教材变更记录集合
     */
	public List<TextbookChange> selectTextbookChangeList(TextbookChange textbookChange);
	
	/**
     * 新增教材变更记录
     * 
     * @param textbookChange 教材变更记录信息
     * @return 结果
     */
	public int insertTextbookChange(TextbookChange textbookChange);
	
	/**
     * 修改教材变更记录
     * 
     * @param textbookChange 教材变更记录信息
     * @return 结果
     */
	public int updateTextbookChange(TextbookChange textbookChange);
		
	/**
     * 删除教材变更记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTextbookChangeByIds(String ids);
	
}
