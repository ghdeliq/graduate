package com.numberone.web.controller.system;

import java.util.Date;
import java.util.List;

import com.numberone.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.numberone.common.annotation.Log;
import com.numberone.common.enums.BusinessType;
import com.numberone.system.domain.CanbookTime;
import com.numberone.system.service.ICanbookTimeService;
import com.numberone.framework.web.base.BaseController;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * 时间控制 信息操作处理
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Controller
@RequestMapping("/system/canbookTime")
public class CanbookTimeController extends BaseController
{
	private static final Logger log = LoggerFactory.getLogger(CanbookTimeController.class);
    private String prefix = "system/canbookTime";
	
	@Autowired
	private ICanbookTimeService canbookTimeService;
	
	@RequiresPermissions("system:canbookTime:view")
	@GetMapping()
	public String canbookTime()
	{
	    return prefix + "/canbookTime";
	}
	
	/**
	 * 查询时间控制列表
	 */
	@RequiresPermissions("system:canbookTime:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CanbookTime canbookTime)
	{
		startPage();
        List<CanbookTime> list = canbookTimeService.selectCanbookTimeList(canbookTime);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出时间控制列表
	 */
	@RequiresPermissions("system:canbookTime:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CanbookTime canbookTime)
    {
    	List<CanbookTime> list = canbookTimeService.selectCanbookTimeList(canbookTime);
        ExcelUtil<CanbookTime> util = new ExcelUtil<CanbookTime>(CanbookTime.class);
        return util.exportExcel(list, "canbookTime");
    }
	
	/**
	 * 新增时间控制
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存时间控制
	 */
	@RequiresPermissions("system:canbookTime:add")
	@Log(title = "时间控制", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CanbookTime canbookTime)
	{
		log.info("新增时间控制数据项开始：");
		CanbookTime c = canbookTimeService.isAllowedOprea(0);
		log.info(Integer.toString( c.getCanId()));
		log.info(ShiroUtils.getLoginName());
		System.out.println("System  ，"+ c.getCanId());
		if (true) { //!c.getCanId().equals(null)
			Date date = new Date();
			boolean allow = canbookTimeService.belongCalendar(date, c.getCanStart(), c.getCanEnd());
			log.info("有 canType = 0");
			if (allow) {
				log.info("判断出了在有效时间内");
			}
		}
		log.info("canType: ", canbookTime.getCanType());
		canbookTime.setCreateBy(ShiroUtils.getLoginName());
		log.info("canbookTime  ", canbookTime.toString());
		return toAjax(canbookTimeService.insertCanbookTime(canbookTime));
	}

	/**
	 * 修改时间控制
	 */
	@GetMapping("/edit/{canId}")
	public String edit(@PathVariable("canId") Integer canId, ModelMap mmap)
	{
		CanbookTime canbookTime = canbookTimeService.selectCanbookTimeById(canId);
		mmap.put("canbookTime", canbookTime);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存时间控制
	 */
	@RequiresPermissions("system:canbookTime:edit")
	@Log(title = "时间控制", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CanbookTime canbookTime)
	{
		canbookTime.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(canbookTimeService.updateCanbookTime(canbookTime));
	}
	
	/**
	 * 删除时间控制
	 */
	@RequiresPermissions("system:canbookTime:remove")
	@Log(title = "时间控制", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(canbookTimeService.deleteCanbookTimeByIds(ids));
	}
	
}
