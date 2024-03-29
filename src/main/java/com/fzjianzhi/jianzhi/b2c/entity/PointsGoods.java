package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * PointsGoods
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_points_goods")
@EqualsAndHashCode(callSuper = true)
public class PointsGoods extends BaseEntity<Long> {

    private String name;

    private Double price;

    private Integer totalNum;

    private Integer remainNum;

    private String title;

    private String detail;
}
