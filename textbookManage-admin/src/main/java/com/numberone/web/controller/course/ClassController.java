package com.numberone.web.controller.course;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysCourse;
import com.numberone.system.domain.TextbookChange;
import com.numberone.system.service.ISysCourseService;
import com.numberone.system.service.ITextbookChangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/course/index")
public class ClassController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    private String prefix = "course/index";

    @Autowired
    private ISysCourseService sysCourseService;

    @Autowired
    private ITextbookChangeService textbookChangeService;

    @RequiresPermissions("course:index:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/course";
    }

    @RequiresPermissions("course:index:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        List<SysCourse> courseList = sysCourseService.selectCourses();
        return getDataTable(courseList);
    }

    /**
     * 新增课程
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存角色
     */
    @RequiresPermissions("course:index:add")
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysCourse course)
    {
        course.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(sysCourseService.insertCourse(course));

    }

    /**
     * 修改课程
     */
    @GetMapping("/edit/{courseId}")
    public String edit(@PathVariable("courseId") Integer courseId, ModelMap mmap)
    {
        mmap.put("course", sysCourseService.getCourseById(courseId));
        return prefix + "/edit";
    }

    /**
     * 修改保存课程
     */
    @RequiresPermissions("course:index:edit")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysCourse course)
    {
        course.setUpdateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(sysCourseService.changeTextbook(course));
    }

    @GetMapping("/textbook/history/{courseId}")
    public String detail(@PathVariable("courseId") Integer courseId, ModelMap mmap)
    {
        TextbookChange textbookChange = new TextbookChange();
        textbookChange.setTcCourseId(courseId);
//        mmap.put("textbookList", textbookChangeService.selectTextbookChangeList(textbookChange));
        mmap.put("textbookChange", textbookChange);
        return "/textbook/history";
    }


//    @RequiresPermissions("course:index:remove")
//    @Log(title = "课程管理", businessType = BusinessType.DELETE)
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        try
//        {
//            return toAjax(sysCourseService.deleteCourseByIds(ids));
//        }
//        catch (Exception e)
//        {
//            return error(e.getMessage());
//        }
//    }

    /**
     * 选择菜单树
     */
//    @GetMapping("/selectMenuTree")
//    public String selectMenuTree()
//    {
//        return prefix + "/tree";
//    }

    /**
     * 角色状态修改
     */
//    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
//    @RequiresPermissions("course:index:edit")
//    @PostMapping("/changeCourseUse")
//    @ResponseBody
//    public AjaxResult changeCourseUse(SysCourse course)
//    {
//        return toAjax(sysCourseService.changeTextbook(course));
//    }
}
