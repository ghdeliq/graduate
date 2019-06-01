package com.numberone.web.controller.textbook;

import com.numberone.common.annotation.Log;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.enums.BusinessType;
import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.BalanceChange;
import com.numberone.system.domain.StuBookRecord;
import com.numberone.system.domain.SysCourse;
import com.numberone.system.service.IBalanceChangeService;
import com.numberone.system.service.ICanbookTimeService;
import com.numberone.system.service.IStuBookRecordService;
import com.numberone.system.service.ISysCourseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/textbook/stuBook")
public class StuBookController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(com.numberone.web.controller.course.ClassController.class);

    private String prefix = "textbook/stuBook";

    @Autowired
    private ISysCourseService sysCourseService;

    @Autowired
    IStuBookRecordService stuBookRecordService;

    @Autowired
    IBalanceChangeService balanceChangeService;

    @Autowired
    ICanbookTimeService canbookTimeService;

//    @RequiresPermissions("course:index:view")
    @GetMapping()
    public String dept()
    {
        return prefix + "/course";
    }

//    @RequiresPermissions("course:index:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        Long deptId = ShiroUtils.getUserDeptId();
        List<SysCourse> courseList = sysCourseService.selectCoursesByDeptId(deptId);
        for (SysCourse sc : courseList) {
            log.info(sc.toString());
            StuBookRecord record = new StuBookRecord();
            record.setSbrStuId(ShiroUtils.getLoginName());
            record.setSbrCourseId(sc.getCourseId());
            List<StuBookRecord> recordList = stuBookRecordService.selectStuBookRecordList(record);
            if (recordList.size() > 0) { // 判断是否预定
                sc.setStuBooked("is");
            }
        }
        return getDataTable(courseList);
    }


    /**
     * 执行预定教材
     */
    @Log(title = "预定教材", businessType = BusinessType.INSERT)
    @PostMapping("/book")
    @ResponseBody
    public AjaxResult edit(Integer courseId)
    {
        boolean flag = canbookTimeService.canRunNow(0);
        if (!flag) {
            return error("当前时间不可预订教材");
        }
        try
        {
            // 获取课程信息
            SysCourse course = sysCourseService.getCourseById(courseId);

            //创建余额变更流水
            BalanceChange balanceChange = new BalanceChange();
            balanceChange.setStuId(ShiroUtils.getLoginName());
            List<BalanceChange> balanceChangeList = balanceChangeService.selectBalanceChangeList(balanceChange);
            BalanceChange oldBalanceChange = balanceChangeList.get(0);
            BalanceChange newBalanceChange = new BalanceChange();
            newBalanceChange.setNewBalance((oldBalanceChange.getNewBalance()-course.getTextbookPrice()));
            newBalanceChange.setCreateBy(ShiroUtils.getLoginName());
            newBalanceChange.setChangeType(0); //订购，余额减少
            newBalanceChange.setCourseId(courseId);
            newBalanceChange.setStuId(ShiroUtils.getLoginName());
            balanceChangeService.insertBalanceChange(newBalanceChange);

            //创建记录
            StuBookRecord stuBookRecord = new StuBookRecord();
            stuBookRecord.setSbrCourseId(courseId);
            stuBookRecord.setSbrStuId(ShiroUtils.getLoginName());
            return toAjax(stuBookRecordService.insertStuBookRecord(stuBookRecord));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 执行预定教材
     */
    @Log(title = "取消预定教材", businessType = BusinessType.INSERT)
    @PostMapping("/bookCancel")
    @ResponseBody
    public AjaxResult bookCancel(Integer courseId) {

        boolean flag = canbookTimeService.canRunNow(0);
        if (!flag) {
            return error("当前时间不可取消预订");
        }

        //获取课程信息
        SysCourse course = sysCourseService.getCourseById(courseId);

        //创建该课程变更记录
        BalanceChange balanceChange = new BalanceChange();
        balanceChange.setStuId(ShiroUtils.getLoginName());
        List<BalanceChange> balanceChangeList = balanceChangeService.selectBalanceChangeList(balanceChange);
        BalanceChange oldBalanceChange = balanceChangeList.get(0);
        BalanceChange newbalanceChange = new BalanceChange();
        newbalanceChange.setStuId(ShiroUtils.getLoginName());
        newbalanceChange.setCourseId(courseId);
        newbalanceChange.setChangeType(1); //取消订购，余额增加
        newbalanceChange.setCreateBy(ShiroUtils.getLoginName());
        newbalanceChange.setNewBalance(oldBalanceChange.getNewBalance() + course.getTextbookPrice());
        balanceChangeService.insertBalanceChange(newbalanceChange);

        //获取当前用户的该课程预订记录，并删除
        StuBookRecord stuBookRecord = new StuBookRecord();
        stuBookRecord.setSbrCourseId(courseId);
        stuBookRecord.setSbrStuId(ShiroUtils.getLoginName());
        List<StuBookRecord> list = stuBookRecordService.selectStuBookRecordList(stuBookRecord);
        for (StuBookRecord record : list) { //执行删除
            stuBookRecordService.deleteStuBookRecordById(record.getSbrId());
        }
        return success("已经取消预定");
    }

}