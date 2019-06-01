package com.numberone.web.controller.textbook;


import com.numberone.common.page.TableDataInfo;
import com.numberone.framework.util.ShiroUtils;
import com.numberone.framework.web.base.BaseController;
import com.numberone.system.domain.TextbookChange;
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
@RequestMapping("/textbook/history")
public class TextbookHistory extends BaseController {

    private String prefix = "textbook/history/";
    private static final Logger log = LoggerFactory.getLogger(com.numberone.web.controller.textbook.TextbookHistory.class);

    @Autowired
    private ITextbookChangeService textbookChangeService;

    @GetMapping()
    public String index() {
        return prefix + "history";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TextbookChange textbookChange)
    {
        startPage();
        List<TextbookChange> list = textbookChangeService.selectTextbookChangeList(textbookChange);
//        log.info("输出测试点");
        return getDataTable(list);
    }

//    @GetMapping("/{courseId}")
//    public String detail(@PathVariable("courseId") Integer courseId, ModelMap mmap)
//    {
//        TextbookChange textbookChange = new TextbookChange();
//        textbookChange.setTcCourseId(courseId);
//        mmap.put("textbookList", textbookChangeService.selectTextbookChangeList(textbookChange));
////        mmap.put("dictList", dictTypeService.selectDictTypeAll());
//        return "system/dict/data/data";
//    }
}
