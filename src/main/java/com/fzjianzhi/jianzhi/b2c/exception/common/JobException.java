package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.JobResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * JobException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class JobException extends BaseException {
    public JobException(JobResultEnum jobResultEnum) {
        super(jobResultEnum);
    }
}
