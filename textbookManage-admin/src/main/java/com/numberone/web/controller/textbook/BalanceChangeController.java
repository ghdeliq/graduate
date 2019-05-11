package com.numberone.web.controller.textbook;

import java.util.List;
import java.util.Date;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.common.annotation.Log;
import com.numberone.common.enums.BusinessType;
import com.numberone.system.domain.BalanceChange;
import com.numberone.system.service.IBalanceChangeService;
import com.numberone.framework.web.base.BaseController;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * 学生余额变更 信息操作处理
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Controller
@RequestMapping("/textbook/balanceChange")
public class BalanceChangeController extends BaseController
{
    private String prefix = "textbook/balanceChange";
	
	@Autowired
	private IBalanceChangeService balanceChangeService;
	
	@RequiresPermissions("system:balanceChange:view")
	@GetMapping()
	public String balanceChange()
	{
	    return prefix + "/balanceChange";
	}
	
	/**
	 * 查询学生余额变更列表
	 */
	@RequiresPermissions("system:balanceChange:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BalanceChange balanceChange)
	{
		startPage();
        List<BalanceChange> list = balanceChangeService.selectBalanceChangeList(balanceChange);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生余额变更列表
	 */
	@RequiresPermissions("system:balanceChange:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BalanceChange balanceChange)
    {
    	List<BalanceChange> list = balanceChangeService.selectBalanceChangeList(balanceChange);
        ExcelUtil<BalanceChange> util = new ExcelUtil<BalanceChange>(BalanceChange.class);
        return util.exportExcel(list, "balanceChange");
    }
	
	/**
	 * 新增学生余额变更
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生余额变更
	 */
	@RequiresPermissions("system:balanceChange:add")
	@Log(title = "学生余额变更", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BalanceChange balanceChange)
	{		
		return toAjax(balanceChangeService.insertBalanceChange(balanceChange));
	}

	/**
	 * 修改学生余额变更
	 */
	@GetMapping("/edit/{createTime}")
	public String edit(@PathVariable("createTime") Date createTime, ModelMap mmap)
	{
		BalanceChange balanceChange = balanceChangeService.selectBalanceChangeById(createTime);
		mmap.put("balanceChange", balanceChange);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生余额变更
	 */
	@RequiresPermissions("system:balanceChange:edit")
	@Log(title = "学生余额变更", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BalanceChange balanceChange)
	{		
		return toAjax(balanceChangeService.updateBalanceChange(balanceChange));
	}
	
	/**
	 * 删除学生余额变更
	 */
	@RequiresPermissions("system:balanceChange:remove")
	@Log(title = "学生余额变更", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(balanceChangeService.deleteBalanceChangeByIds(ids));
	}
	
}
