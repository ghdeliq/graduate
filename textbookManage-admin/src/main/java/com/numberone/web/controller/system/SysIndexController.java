package com.numberone.web.controller.system;

import java.util.List;

import com.numberone.framework.web.domain.server.Sys;
import com.numberone.system.domain.SysRole;
import com.numberone.system.domain.SysUserRole;
import com.numberone.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.numberone.common.config.Global;
import com.numberone.system.domain.SysMenu;
import com.numberone.system.domain.SysUser;
import com.numberone.system.service.ISysMenuService;
import com.numberone.framework.web.base.BaseController;

import javax.management.relation.Role;

/**
 * 首页 业务处理
 * 
 * @author numberone
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysRoleService roleService;



    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = getSysUser();
        //获取角色信息
        SysUserRole userRole = roleService.selectRoleIdByUserId(user.getUserId());
        SysRole role = roleService.selectRoleById(userRole.getRoleId());

        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("role", role);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "main";
    }
//    @GetMapping("/system/user/roleKey")
//    public String roleKey(ModelMap mmap)
//    {
//
//    }
}
