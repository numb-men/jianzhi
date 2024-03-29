package com.fzjianzhi.jianzhi.base.system.exception.common;


import com.fzjianzhi.jianzhi.base.exception.common.BaseException;
import com.fzjianzhi.jianzhi.base.system.exception.enums.SystemResultEnum;

/**
 * SystemException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
public class SystemException extends BaseException {
    public SystemException(SystemResultEnum systemResultEnum) {
        super(systemResultEnum);
    }
}
