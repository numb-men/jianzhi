package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Task
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_task")
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseEntity<Long> {

    private String title;

    private Integer type;

    private Double award;

    private Integer duration;

    private Date deadline;
}
