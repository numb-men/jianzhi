package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * WithdrawCash
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_withdraw_cash")
@EqualsAndHashCode(callSuper = true)
public class WithdrawCash extends BaseEntity<Long> {

    private Long userId;

    private Double amount;

    private Double balance;

    private Integer status;
}
