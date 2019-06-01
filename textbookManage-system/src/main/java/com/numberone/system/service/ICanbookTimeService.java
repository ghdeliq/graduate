package com.numberone.system.service;

import com.numberone.system.domain.CanbookTime;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 时间控制 服务层
 * 
 * @author guohui
 * @date 2019-05-11
 */
public interface ICanbookTimeService 
{

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
     * 修改时间控制
     * 
     * @param canbookTime 时间控制信息
     * @return 结果
     */
	public int updateCanbookTime(CanbookTime canbookTime);
		
	/**
     * 删除时间控制信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCanbookTimeByIds(String ids);

	/**
	 * 判断是否在开始时间-结束时间内
	 * 如果有多条数据，以createTime
	 * @param canType
	 * @return true or false
	 */
	public CanbookTime isAllowedOprea(Integer canType);

	/**
	 * 判断时间是否在时间段内
	 *
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public  boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) ;

	/**
	 * 判断当前时间是否可执行
	 * @Param canType
	 */
	public boolean canRunNow(Integer canType);

	
}
