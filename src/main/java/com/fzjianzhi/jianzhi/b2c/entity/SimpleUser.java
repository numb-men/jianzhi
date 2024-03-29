package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * SimpleUser
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_simple_user")
@EqualsAndHashCode(callSuper = true)
public class SimpleUser extends BaseEntity<Long> {

    private Long b2cBaseUserId;
}
