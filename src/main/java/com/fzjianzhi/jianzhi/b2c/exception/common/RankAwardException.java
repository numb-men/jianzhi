package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.RankAwardResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * RankAwardException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class RankAwardException extends BaseException {
    public RankAwardException(RankAwardResultEnum rankAwardResultEnum) {
        super(rankAwardResultEnum);
    }
}
