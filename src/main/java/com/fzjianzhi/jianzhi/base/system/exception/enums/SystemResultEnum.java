package com.fzjianzhi.jianzhi.base.system.exception.enums;


import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * SystemResultEnum
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
@Getter
@AllArgsConstructor
public enum  SystemResultEnum implements ResultEnum {
    USER_NOT_FOUND(701, "用户不存在"),
    ROLE_NOT_FOUND(702, "角色不存在"),
    RESOURCE_NOT_FOUND(703, "资源不存在"),
    ;

    private Integer code;
    private String message;
}
