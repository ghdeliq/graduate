package com.numberone.system.service.impl;

import java.util.List;

import com.numberone.system.domain.SysCourse;
import com.numberone.system.mapper.SysCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.system.mapper.TextbookChangeMapper;
import com.numberone.system.domain.TextbookChange;
import com.numberone.system.service.ITextbookChangeService;
import com.numberone.common.support.Convert;

/**
 * 教材变更记录 服务层实现
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Service
public class TextbookChangeServiceImpl implements ITextbookChangeService 
{
	@Autowired
	private TextbookChangeMapper textbookChangeMapper;

	@Autowired
	private SysCourseMapper courseMapper;

	/**
     * 查询教材变更记录信息
     * 
     * @param tcId 教材变更记录ID
     * @return 教材变更记录信息
     */
    @Override
	public TextbookChange selectTextbookChangeById(Integer tcId)
	{
	    return textbookChangeMapper.selectTextbookChangeById(tcId);
	}
	
	/**
     * 查询教材变更记录列表
     * 
     * @param textbookChange 教材变更记录信息
     * @return 教材变更记录集合
     */
	@Override
	public List<TextbookChange> selectTextbookChangeList(TextbookChange textbookChange)
	{
		List<TextbookChange> list =  textbookChangeMapper.selectTextbookChangeList(textbookChange);
		for (TextbookChange t : list) { //获取courseName
			SysCourse course = courseMapper.selectCourseById(t.getTcCourseId());
			t.setCourseName(course.getCourseName());
		}
		return list;
	}
	
    /**
     * 新增教材变更记录
     * 
     * @param textbookChange 教材变更记录信息
     * @return 结果
     */
	@Override
	public int insertTextbookChange(TextbookChange textbookChange)
	{
	    return textbookChangeMapper.insertTextbookChange(textbookChange);
	}
	
	/**
     * 修改教材变更记录
     * 
     * @param textbookChange 教材变更记录信息
     * @return 结果
     */
	@Override
	public int updateTextbookChange(TextbookChange textbookChange)
	{
	    return textbookChangeMapper.updateTextbookChange(textbookChange);
	}

	/**
     * 删除教材变更记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTextbookChangeByIds(String ids)
	{
		return textbookChangeMapper.deleteTextbookChangeByIds(Convert.toStrArray(ids));
	}
	
}
