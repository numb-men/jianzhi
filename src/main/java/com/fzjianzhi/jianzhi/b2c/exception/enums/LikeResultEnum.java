package com.fzjianzhi.jianzhi.b2c.exception.enums;

import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LikeResultEnum
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Getter
@AllArgsConstructor
public enum LikeResultEnum implements ResultEnum {
    
    ;
    
    private Integer code;
    private String message;
}
