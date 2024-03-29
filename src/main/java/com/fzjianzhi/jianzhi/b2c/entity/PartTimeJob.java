package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

/**
 * PartTimeJob
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_part_time_job")
@EqualsAndHashCode(callSuper = true)
public class PartTimeJob extends BaseEntity<Long> {

    private String title;

    private Integer businessUser;

    private String detail;

    private Date startTime;

    private Date endTime;

    private String address;

    private String detailAddress;

    private Double wage;

    private Integer wageTimeType;

    private Double totalWage;

    private Integer wagePayType;

    private Integer type;

    private Integer status;

    private Integer needNum;

    private Integer gotNum;

    private Integer starNum;
}
