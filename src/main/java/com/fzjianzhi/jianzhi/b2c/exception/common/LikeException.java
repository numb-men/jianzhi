package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.LikeResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * LikeException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class LikeException extends BaseException {
    public LikeException(LikeResultEnum likeResultEnum) {
        super(likeResultEnum);
    }
}
