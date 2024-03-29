package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.WalletRecordResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * WalletRecordException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class WalletRecordException extends BaseException {
    public WalletRecordException(WalletRecordResultEnum walletRecordResultEnum) {
        super(walletRecordResultEnum);
    }
}
