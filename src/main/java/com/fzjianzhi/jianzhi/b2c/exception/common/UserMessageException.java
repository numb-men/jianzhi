package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.UserMessageResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * UserMessageException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class UserMessageException extends BaseException {
    public UserMessageException(UserMessageResultEnum userMessageResultEnum) {
        super(userMessageResultEnum);
    }
}
