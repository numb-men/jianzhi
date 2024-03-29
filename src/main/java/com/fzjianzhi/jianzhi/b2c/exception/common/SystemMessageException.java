package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.SystemMessageResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * SystemMessageException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class SystemMessageException extends BaseException {
    public SystemMessageException(SystemMessageResultEnum systemMessageResultEnum) {
        super(systemMessageResultEnum);
    }
}
