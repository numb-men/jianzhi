package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.CustomerUserResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * CustomerUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
public class CustomerUserException extends BaseException {
    public CustomerUserException(CustomerUserResultEnum customerUserResultEnum) {
        super(customerUserResultEnum);
    }
}
