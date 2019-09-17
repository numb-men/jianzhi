package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * PointsGoodsExchange
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_points_goods_exchange")
@EqualsAndHashCode(callSuper = true)
public class PointsGoodsExchange extends BaseEntity<Long> {

    private Long userId;

    private Integer exchangeNum;

    private Long pointsGoodsId;

    private Integer status;
}
