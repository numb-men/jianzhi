package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.TaskRecordResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * TaskRecordException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class TaskRecordException extends BaseException {
    public TaskRecordException(TaskRecordResultEnum taskRecordResultEnum) {
        super(taskRecordResultEnum);
    }
}
