package com.fzjianzhi.jianzhi.b2c.exception.enums;

import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AgencyRecordResultEnum
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Getter
@AllArgsConstructor
public enum AgencyRecordResultEnum implements ResultEnum {
    
    ;
    
    private Integer code;
    private String message;
}
