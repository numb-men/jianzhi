package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.B2cBaseUserResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * B2cBaseUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
public class B2cBaseUserException extends BaseException {
    public B2cBaseUserException(B2cBaseUserResultEnum b2cBaseUserResultEnum) {
        super(b2cBaseUserResultEnum);
    }
}
