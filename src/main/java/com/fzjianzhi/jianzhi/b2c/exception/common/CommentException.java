package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.CommentResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * CommentException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class CommentException extends BaseException {
    public CommentException(CommentResultEnum commentResultEnum) {
        super(commentResultEnum);
    }
}
