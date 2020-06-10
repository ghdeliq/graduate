package com.numberone.common.exception.user;

import com.numberone.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author guohui
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
