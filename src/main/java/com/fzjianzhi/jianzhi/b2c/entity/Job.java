package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Job
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_job")
@EqualsAndHashCode(callSuper = true)
public class Job extends BaseEntity<Long> {

    private String title;

    private Long businessUser;

    private String detail;

    private String address;

    private String detailAddress;

    private Double wage;

    private Integer type;

    private Integer status;

    private Integer needNum;

    private Integer gotNum;

    private Integer starNum;
}
