package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.WithdrawCashResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * WithdrawCashException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class WithdrawCashException extends BaseException {
    public WithdrawCashException(WithdrawCashResultEnum withdrawCashResultEnum) {
        super(withdrawCashResultEnum);
    }
}
