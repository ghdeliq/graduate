package com.numberone.system.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.numberone.system.mapper.CanbookTimeMapper;
import com.numberone.system.domain.CanbookTime;
import com.numberone.system.service.ICanbookTimeService;
import com.numberone.common.support.Convert;

/**
 * 时间控制 服务层实现
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Service
public class CanbookTimeServiceImpl implements ICanbookTimeService 
{
	@Autowired
	private CanbookTimeMapper canbookTimeMapper;

	/**
     * 查询时间控制信息
     * 
     * @param canId 时间控制ID
     * @return 时间控制信息
     */
    @Override
	public CanbookTime selectCanbookTimeById(Integer canId)
	{
	    return canbookTimeMapper.selectCanbookTimeById(canId);
	}
	
	/**
     * 查询时间控制列表
     * 
     * @param canbookTime 时间控制信息
     * @return 时间控制集合
     */
	@Override
	public List<CanbookTime> selectCanbookTimeList(CanbookTime canbookTime)
	{
	    return canbookTimeMapper.selectCanbookTimeList(canbookTime);
	}
	
    /**
     * 新增时间控制
     * 
     * @param canbookTime 时间控制信息
     * @return 结果
     */
	@Override
	public int insertCanbookTime(CanbookTime canbookTime)
	{

		//未保证只有一个时间有效，其他时间置否
		canbookTimeMapper.updateCanbookTimeMakeNo(canbookTime);

		return canbookTimeMapper.insertCanbookTime(canbookTime);
	}
	
	/**
     * 修改时间控制
     * 
     * @param canbookTime 时间控制信息
     * @return 结果
     */
	@Override
	public int updateCanbookTime(CanbookTime canbookTime)
	{
		if(canbookTime.getCanType() == null) {
		} else {
			//未保证只有一个时间有效，其他时间置否
			canbookTimeMapper.updateCanbookTimeMakeNo(canbookTime);
		}
	    return canbookTimeMapper.updateCanbookTime(canbookTime);
	}

	/**
     * 删除时间控制对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCanbookTimeByIds(String ids)
	{
		return canbookTimeMapper.deleteCanbookTimeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 判断是否在开始时间-结束时间内
	 * 如果有多条数据，以createTime
	 *
	 * @param canType
	 * @return true or false
	 */
	@Override
	public CanbookTime isAllowedOprea(Integer canType) {
		CanbookTime list = canbookTimeMapper.selectCanbookTimeCanUse(canType);
//		if(list.size() > 0) {
//			CanbookTime c = list.get(0);
//			return c;
//		}else {
//			return new CanbookTime();
//		}
		return list;
	}

	/**
	 * 判断时间是否在时间段内
	 *
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	@Override
	public boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

}
