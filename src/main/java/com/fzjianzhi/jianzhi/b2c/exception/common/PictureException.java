package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.PictureResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * PictureException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class PictureException extends BaseException {
    public PictureException(PictureResultEnum pictureResultEnum) {
        super(pictureResultEnum);
    }
}
