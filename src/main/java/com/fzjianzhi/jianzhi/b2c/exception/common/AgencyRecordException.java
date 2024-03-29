package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.AgencyRecordResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * AgencyRecordException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class AgencyRecordException extends BaseException {
    public AgencyRecordException(AgencyRecordResultEnum agencyRecordResultEnum) {
        super(agencyRecordResultEnum);
    }
}
