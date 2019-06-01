package com.numberone.web.controller.textbook;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.SysCourse;
import com.numberone.system.domain.TextbookChange;
import com.numberone.system.service.ICanbookTimeService;
import com.numberone.system.service.ISysCourseService;
import com.numberone.system.service.ITextbookChangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/textbook/textbookChangeCheck")
public class TextbookChangeCheckController extends BaseController {

    private String prefix = "textbook/textbookChangeCheck";
    private static final Logger log = LoggerFactory.getLogger(com.numberone.web.controller.textbook.TextbookChangeCheckController.class);

    @Autowired
    private ITextbookChangeService textbookChangeService;

    @Autowired
    private ISysCourseService courseService;

    @Autowired
    private ICanbookTimeService canbookTimeService;

    @GetMapping()
    public String textbookChange()
    {
        return prefix + "/textbookChange";
    }

    /**
     * 查询教材变更记录列表
     */
//    @RequiresPermissions("system:textbookChange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TextbookChange textbookChange)
    {
        startPage();
        List<TextbookChange> list = textbookChangeService.selectTextbookChangeList(textbookChange);
        log.info("输出测试点");
        return getDataTable(list);
    }

    /**
     * 审核教材变更记录
     */
    @GetMapping("/check/{tcId}")
    public String edit(@PathVariable("tcId") Integer tcId, ModelMap mmap)
    {
        TextbookChange textbookChange = textbookChangeService.selectTextbookChangeById(tcId);
        SysCourse course = courseService.getCourseById(textbookChange.getTcCourseId());
        textbookChange.setCourseName(course.getCourseName());
        mmap.put("textbookChange", textbookChange);
        return prefix + "/check";
    }

    /**
     * 修改审核信息 教材变更记录
     */
//    @RequiresPermissions("system:textbookChange:edit")
    @Log(title = "教材变更", businessType = BusinessType.UPDATE)
    @PostMapping("/check")
    @ResponseBody
    public AjaxResult editSave(Integer tcId, String check)
    {
        boolean flag = canbookTimeService.canRunNow(1);
        if (!flag) {
            return error("当前时间禁止变更教材");
        }
        log.info("教材变更", tcId + check);
        TextbookChange textbookChange = textbookChangeService.selectTextbookChangeById(tcId);
        if (textbookChange.getTcState() != 0) {
            return error("此工单已经被" + textbookChange.getTcCheckBy() +"审核了");
        }
        SysCourse course = courseService.getCourseById(textbookChange.getTcCourseId());
        textbookChange.setTcOldTextbook(course.getCourseTextbook());
        if ("allow".equals(check)) { //通过
            textbookChange.setTcState(1);
            course.setCourseTextbook(textbookChange.getTcNewTextbook());
            course.setTextbookPrice(textbookChange.getTcNewPrice());
            courseService.updateCourse(course);
        }else { // 驳回
            textbookChange.setTcState(2);

        }
        textbookChange.setTcCheckBy(ShiroUtils.getLoginName());

        return toAjax(textbookChangeService.updateTextbookChange(textbookChange));
    }
}
