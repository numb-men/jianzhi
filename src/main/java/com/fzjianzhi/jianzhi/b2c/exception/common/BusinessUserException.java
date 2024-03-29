package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.BusinessUserResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * BusinessUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
public class BusinessUserException extends BaseException {
    public BusinessUserException(BusinessUserResultEnum businessUserResultEnum) {
        super(businessUserResultEnum);
    }
}
