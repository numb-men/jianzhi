package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.TaskResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * TaskException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class TaskException extends BaseException {
    public TaskException(TaskResultEnum taskResultEnum) {
        super(taskResultEnum);
    }
}
