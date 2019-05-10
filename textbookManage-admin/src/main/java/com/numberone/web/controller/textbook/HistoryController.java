package com.numberone.web.controller.textbook;

import com.numberone.common.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 教材历史查看
 */
@Controller
@RequestMapping("/textbook")
public class HistoryController {


    /**
     * 查询公告列表
     */
//    @RequiresPermissions("system:notice:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list(SysNotice notice)
//    {
//        startPage();
//        List<SysNotice> list = noticeService.selectNoticeList(notice);
//        return getDataTable(list);
//    }
}
