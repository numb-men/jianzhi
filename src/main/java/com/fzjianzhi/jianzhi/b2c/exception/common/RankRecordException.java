package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.RankRecordResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * RankRecordException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class RankRecordException extends BaseException {
    public RankRecordException(RankRecordResultEnum rankRecordResultEnum) {
        super(rankRecordResultEnum);
    }
}
