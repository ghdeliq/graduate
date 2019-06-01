package com.numberone.web.controller.textbook;

import java.util.List;

import com.numberone.framework.util.ShiroUtils;
import com.numberone.system.domain.SysCourse;
import com.numberone.system.service.ICanbookTimeService;
import com.numberone.system.service.ISysCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.numberone.system.domain.TextbookChange;
import com.numberone.system.service.ITextbookChangeService;
import com.numberone.framework.web.base.BaseController;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * 教材变更记录 信息操作处理
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Controller
@RequestMapping("/textbook/textbookChangeApply")
public class TextbookChangeApplyController extends BaseController
{
    private String prefix = "textbook/textbookChangeApply";
	private static final Logger log = LoggerFactory.getLogger(com.numberone.web.controller.textbook.TextbookChangeApplyController.class);
	
	@Autowired
	private ITextbookChangeService textbookChangeService;

	@Autowired
	private ISysCourseService courseService;

	@Autowired
	private ICanbookTimeService canbookTimeService;
	
//	@RequiresPermissions("system:textbookChange:view")
	@GetMapping()
	public String textbookChange()
	{
	    return prefix + "/textbookChange";
	}
	
	/**
	 * 查询教材变更记录列表
	 */
//	@RequiresPermissions("system:textbookChange:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TextbookChange textbookChange)
	{
		startPage();
		textbookChange.setTcChangeBy(ShiroUtils.getLoginName()); //只能查询到当前用户提交的工单
        List<TextbookChange> list = textbookChangeService.selectTextbookChangeList(textbookChange);
        log.info("输出测试点");
		return getDataTable(list);
	}
	
	
	/**
	 * 导出教材变更记录列表
	 */
//	@RequiresPermissions("system:textbookChange:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TextbookChange textbookChange)
    {
    	List<TextbookChange> list = textbookChangeService.selectTextbookChangeList(textbookChange);
        ExcelUtil<TextbookChange> util = new ExcelUtil<TextbookChange>(TextbookChange.class);
        return util.exportExcel(list, "textbookChangeApply");
    }
	
	/**
	 * 新增教材变更记录
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("courses",courseService.selectUseCourses());
//		mmap.put("test","test");
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存教材变更记录
	 */
//	@RequiresPermissions("system:textbookChange:add")
	@Log(title = "教材变更记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TextbookChange textbookChange)
	{
		boolean flag = canbookTimeService.canRunNow(1);
		if (!flag) {
			return error("当前时间不可变更教材");
		}
		SysCourse course = courseService.getCourseById(textbookChange.getTcCourseId());
		textbookChange.setTcOldTextbook(course.getCourseTextbook());
		textbookChange.setTcChangeBy(ShiroUtils.getLoginName());
		return toAjax(textbookChangeService.insertTextbookChange(textbookChange));
	}

	/**
	 * 修改教材变更记录
	 */
	@GetMapping("/edit/{tcId}")
	public String edit(@PathVariable("tcId") Integer tcId, ModelMap mmap)
	{
		TextbookChange textbookChange = textbookChangeService.selectTextbookChangeById(tcId);
		mmap.put("textbookChange", textbookChange);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存教材变更记录
	 */
//	@RequiresPermissions("system:textbookChange:edit")
	@Log(title = "教材变更记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TextbookChange textbookChange)
	{
		boolean flag = canbookTimeService.canRunNow(1);
		if (!flag) {
			return error("当前时间不可变更教材");
		}
		return toAjax(textbookChangeService.updateTextbookChange(textbookChange));
	}
	
	/**
	 * 删除教材变更记录
	 */
//	@RequiresPermissions("system:textbookChange:remove")
	@Log(title = "教材变更记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(textbookChangeService.deleteTextbookChangeByIds(ids));
	}
	
}
