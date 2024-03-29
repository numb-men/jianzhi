package com.fzjianzhi.jianzhi.b2c.exception.enums;

import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * B2cBaseUserResultEnum
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
@Getter
@AllArgsConstructor
public enum B2cBaseUserResultEnum implements ResultEnum {
    ;

    private Integer code;
    private String message;
}
