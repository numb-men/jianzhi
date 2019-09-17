package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * AgencyUser
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_agency_user")
@EqualsAndHashCode(callSuper = true)
public class AgencyUser extends BaseEntity<Long> {

    private Long userId;

    private String url;
}
