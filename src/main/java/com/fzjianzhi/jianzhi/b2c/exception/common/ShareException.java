package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.ShareResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * ShareException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class ShareException extends BaseException {
    public ShareException(ShareResultEnum shareResultEnum) {
        super(shareResultEnum);
    }
}
