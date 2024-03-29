package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * RankAward
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_rank_award")
@EqualsAndHashCode(callSuper = true)
public class RankAward extends BaseEntity<Long> {

    private Integer ranking;

    private Double award;
}
