package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.SimpleUserResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * SimpleUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class SimpleUserException extends BaseException {
    public SimpleUserException(SimpleUserResultEnum simpleUserResultEnum) {
        super(simpleUserResultEnum);
    }
}
