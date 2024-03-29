package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.IndexPictureResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * IndexPictureException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class IndexPictureException extends BaseException {
    public IndexPictureException(IndexPictureResultEnum indexPictureResultEnum) {
        super(indexPictureResultEnum);
    }
}
