package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.PartTimeJobResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * PartTimeJobException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class PartTimeJobException extends BaseException {
    public PartTimeJobException(PartTimeJobResultEnum partTimeJobResultEnum) {
        super(partTimeJobResultEnum);
    }
}
