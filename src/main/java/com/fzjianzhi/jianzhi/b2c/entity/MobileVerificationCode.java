package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

/**
 * MobileVerificationCode
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_mobile_verification_code")
@EqualsAndHashCode(callSuper = true)
public class MobileVerificationCode extends BaseEntity<Long> {

    private String phone;

    private String code;

    private Date expire;

    private Integer status;
}
