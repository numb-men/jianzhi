package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.MobileVerificationCodeResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * MobileVerificationCodeException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class MobileVerificationCodeException extends BaseException {
    public MobileVerificationCodeException(MobileVerificationCodeResultEnum mobileVerificationCodeResultEnum) {
        super(mobileVerificationCodeResultEnum);
    }
}
