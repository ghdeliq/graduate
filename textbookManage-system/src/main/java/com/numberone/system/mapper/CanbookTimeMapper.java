package com.numberone.system.mapper;

import com.numberone.system.domain.CanbookTime;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 时间控制 数据层
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Component
public interface CanbookTimeMapper 
{
	/**
	 * 查询最新时间控制信息
	 *
	 * @param canType 时间控制类型
	 * @return 时间控制信息集合
	 */
	public CanbookTime selectCanbookTimeCanUse( Integer canType); //@Param("canId") Integer canId,
	/**
     * 查询时间控制信息
     * 
     * @param canId 时间控制ID
     * @return 时间控制信息
     */
	public CanbookTime selectCanbookTimeById(Integer canId);
	
	/**
     * 查询时间控制列表
     * 
     * @param canbookTime 时间控制信息
     * @return 时间控制集合
     */
	public List<CanbookTime> selectCanbookTimeList(CanbookTime canbookTime);
	
	/**
     * 新增时间控制
     * 
     * @param canbookTime 时间控制信息
     * @return 结果
     */
	public int insertCanbookTime(CanbookTime canbookTime);

	/**
	 * 修改时间控制, 将该类型现有时间全部置否
	 *
	 * @param canbookTime 时间控制信息
	 * @return 结果
	 */
	public int updateCanbookTimeMakeNo(CanbookTime canbookTime);
	/**
     * 修改时间控制
     * 
     * @param canbookTime 时间控制信息
     * @return 结果
     */
	public int updateCanbookTime(CanbookTime canbookTime);
	
	/**
     * 删除时间控制
     * 
     * @param canId 时间控制ID
     * @return 结果
     */
	public int deleteCanbookTimeById(Integer canId);
	
	/**
     * 批量删除时间控制
     * 
     * @param canIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCanbookTimeByIds(String[] canIds);
	
}