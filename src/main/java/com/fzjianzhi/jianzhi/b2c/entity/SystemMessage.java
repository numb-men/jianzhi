package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * SystemMessage
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_system_message")
@EqualsAndHashCode(callSuper = true)
public class SystemMessage extends BaseEntity<Long> {

    private String title;

    private Integer type;

    private String content;
}
