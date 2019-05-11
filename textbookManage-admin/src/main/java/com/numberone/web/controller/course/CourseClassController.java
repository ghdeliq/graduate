package com.numberone.web.controller.course;

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
import com.numberone.system.domain.CourseClass;
import com.numberone.system.service.ICourseClassService;
import com.numberone.framework.web.base.BaseController;
import com.numberone.common.page.TableDataInfo;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.poi.ExcelUtil;

/**
 * 课程-班级对应 信息操作处理
 * 
 * @author guohui
 * @date 2019-05-11
 */
@Controller
@RequestMapping("/course/courseClass")
public class CourseClassController extends BaseController
{
    private String prefix = "course/courseClass";
	
	@Autowired
	private ICourseClassService courseClassService;
	
	@RequiresPermissions("system:courseClass:view")
	@GetMapping()
	public String courseClass()
	{
	    return prefix + "/courseClass";
	}
	
	/**
	 * 查询课程-班级对应列表
	 */
	@RequiresPermissions("system:courseClass:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CourseClass courseClass)
	{
		startPage();
        List<CourseClass> list = courseClassService.selectCourseClassList(courseClass);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出课程-班级对应列表
	 */
	@RequiresPermissions("system:courseClass:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CourseClass courseClass)
    {
    	List<CourseClass> list = courseClassService.selectCourseClassList(courseClass);
        ExcelUtil<CourseClass> util = new ExcelUtil<CourseClass>(CourseClass.class);
        return util.exportExcel(list, "courseClass");
    }
	
	/**
	 * 新增课程-班级对应
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存课程-班级对应
	 */
	@RequiresPermissions("system:courseClass:add")
	@Log(title = "课程-班级对应", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CourseClass courseClass)
	{		
		return toAjax(courseClassService.insertCourseClass(courseClass));
	}

	/**
	 * 修改课程-班级对应
	 */
	@GetMapping("/edit/{ccId}")
	public String edit(@PathVariable("ccId") Integer ccId, ModelMap mmap)
	{
		CourseClass courseClass = courseClassService.selectCourseClassById(ccId);
		mmap.put("courseClass", courseClass);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存课程-班级对应
	 */
	@RequiresPermissions("system:courseClass:edit")
	@Log(title = "课程-班级对应", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CourseClass courseClass)
	{		
		return toAjax(courseClassService.updateCourseClass(courseClass));
	}
	
	/**
	 * 删除课程-班级对应
	 */
	@RequiresPermissions("system:courseClass:remove")
	@Log(title = "课程-班级对应", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(courseClassService.deleteCourseClassByIds(ids));
	}
	
}
