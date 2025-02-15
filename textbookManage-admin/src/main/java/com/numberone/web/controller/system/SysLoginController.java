package com.numberone.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.numberone.framework.util.ShiroUtils;
import com.numberone.system.domain.SysRole;
import com.numberone.system.domain.SysUserRole;
import com.numberone.system.service.ISysRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.numberone.common.base.AjaxResult;
import com.numberone.common.utils.ServletUtils;
import com.numberone.common.utils.StringUtils;
import com.numberone.framework.web.base.BaseController;

/**
 * 登录验证
 * 
 * @author guohui
 */
@Controller
public class SysLoginController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(SysLoginController.class);

    @Autowired
    private ISysRoleService roleService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        log.info("触发login【GET】");
        log.info("[get]登录信息为：request", request);
        log.info("[get]登录信息为：response", response);
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            log.info("[get]登录信息为：", response);
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe, String userType, String test, String validateCode)
    {
        log.info("触发login【POST】");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        log.info("== 登录中 ==");
        log.info("username = "+username+"  password = "+password+" userType = "+userType+" remeberMe = "+rememberMe+" validateCode = "+validateCode+" test = "+test);
        try
        {
            subject.login(token);
            SysUserRole userRole = roleService.selectRoleIdByUserId(ShiroUtils.getUserId());
            SysRole role = roleService.selectRoleById(userRole.getRoleId());
            if(role.getRoleKey().equals("admin")) {
            }else {
                if (role.getRoleKey().equals(userType)) {
                } else {
                    return error("用户或密码错误");
                }
            }
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "/error/unauth";
    }
}
