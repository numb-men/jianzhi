package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * UserMessage
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_user_message")
@EqualsAndHashCode(callSuper = true)
public class UserMessage extends BaseEntity<Long> {

    private Long sendUserId;

    private Long acceptUserId;

    private String content;

    private Integer type;

    private Integer status;
}
