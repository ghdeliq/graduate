package com.numberone.framework.util;

import org.apache.commons.lang3.StringUtils;
import com.numberone.common.constant.PermissionConstants;
import com.numberone.common.utils.MessageUtils;

/**
 * permission 工具类
 * 
 * @author guohui
 */
public class PermissionUtils
{
    /**
     * 权限错误消息提醒
     * 
     * @param permissionsStr 错误信息
     * @return
     */
    public static String getMsg(String permissionsStr)
    {
        String permission = StringUtils.substringBetween(permissionsStr, "[", "]");
        String msg = MessageUtils.message("no.view.permission", permission);
        if (StringUtils.endsWithIgnoreCase(permission, PermissionConstants.ADD_PERMISSION))
        {
            msg = MessageUtils.message("no.create.permission", permission);
        }
        else if (StringUtils.endsWithIgnoreCase(permission, PermissionConstants.EDIT_PERMISSION))
        {
            msg = MessageUtils.message("no.update.permission", permission);
        }
        else if (StringUtils.endsWithIgnoreCase(permission, PermissionConstants.REMOVE_PERMISSION))
        {
            msg = MessageUtils.message("no.delete.permission", permission);
        }
        else if (StringUtils.endsWithIgnoreCase(permission, PermissionConstants.EXPORT_PERMISSION))
        {
            msg = MessageUtils.message("no.export.permission", permission);
        }
        else if (StringUtils.endsWithAny(permission,
                new String[] { PermissionConstants.VIEW_PERMISSION, PermissionConstants.LIST_PERMISSION }))
        {
            msg = MessageUtils.message("no.view.permission", permission);
        }
        return msg;
    }
}
