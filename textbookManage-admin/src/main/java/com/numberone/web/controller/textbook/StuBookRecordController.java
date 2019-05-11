package com.numberone.web.controller.textbook;

import java.util.List;
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
import com.numberone.system.domain.StuBookRecord;
import com.numberone.system.service.IStuBookRecordService;
import com.numberone.framework.web.base.BaseController;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * 学生预定教材记录 信息操作处理
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Controller
@RequestMapping("/textbook/stuBookRecord")
public class StuBookRecordController extends BaseController
{
    private String prefix = "textbook/stuBookRecord";
	
	@Autowired
	private IStuBookRecordService stuBookRecordService;
	
	@RequiresPermissions("system:stuBookRecord:view")
	@GetMapping()
	public String stuBookRecord()
	{
	    return prefix + "/stuBookRecord";
	}
	
	/**
	 * 查询学生预定教材记录列表
	 */
	@RequiresPermissions("system:stuBookRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(StuBookRecord stuBookRecord)
	{
		startPage();
        List<StuBookRecord> list = stuBookRecordService.selectStuBookRecordList(stuBookRecord);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出学生预定教材记录列表
	 */
	@RequiresPermissions("system:stuBookRecord:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StuBookRecord stuBookRecord)
    {
    	List<StuBookRecord> list = stuBookRecordService.selectStuBookRecordList(stuBookRecord);
        ExcelUtil<StuBookRecord> util = new ExcelUtil<StuBookRecord>(StuBookRecord.class);
        return util.exportExcel(list, "stuBookRecord");
    }
	
	/**
	 * 新增学生预定教材记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存学生预定教材记录
	 */
	@RequiresPermissions("system:stuBookRecord:add")
	@Log(title = "学生预定教材记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(StuBookRecord stuBookRecord)
	{		
		return toAjax(stuBookRecordService.insertStuBookRecord(stuBookRecord));
	}

	/**
	 * 修改学生预定教材记录
	 */
	@GetMapping("/edit/{sbrId}")
	public String edit(@PathVariable("sbrId") Integer sbrId, ModelMap mmap)
	{
		StuBookRecord stuBookRecord = stuBookRecordService.selectStuBookRecordById(sbrId);
		mmap.put("stuBookRecord", stuBookRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存学生预定教材记录
	 */
	@RequiresPermissions("system:stuBookRecord:edit")
	@Log(title = "学生预定教材记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(StuBookRecord stuBookRecord)
	{		
		return toAjax(stuBookRecordService.updateStuBookRecord(stuBookRecord));
	}
	
	/**
	 * 删除学生预定教材记录
	 */
	@RequiresPermissions("system:stuBookRecord:remove")
	@Log(title = "学生预定教材记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stuBookRecordService.deleteStuBookRecordByIds(ids));
	}
	
}
