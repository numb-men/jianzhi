package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.SearchRecordResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * SearchRecordException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class SearchRecordException extends BaseException {
    public SearchRecordException(SearchRecordResultEnum searchRecordResultEnum) {
        super(searchRecordResultEnum);
    }
}
