package com.fzjianzhi.jianzhi.wx.user;


import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * WxUserException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/15
 */
public class WxUserException extends BaseException {
    public WxUserException(WxUserResultEnum wxUserResultEnum) {
        super(wxUserResultEnum);
    }
}
