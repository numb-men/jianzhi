package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.AgencyUserResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * AgencyUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class AgencyUserException extends BaseException {
    public AgencyUserException(AgencyUserResultEnum agencyUserResultEnum) {
        super(agencyUserResultEnum);
    }
}
