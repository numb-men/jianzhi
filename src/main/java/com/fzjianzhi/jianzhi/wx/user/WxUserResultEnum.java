package com.fzjianzhi.jianzhi.wx.user;


import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * WxUserResultEnum
 * TODO
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/15
 */
@AllArgsConstructor
@Getter
public enum WxUserResultEnum implements ResultEnum {
    SAVE_USER_INFO_FAIL(3001, "保存用户信息失败")
    ;
    private Integer code;
    private String message;
}
