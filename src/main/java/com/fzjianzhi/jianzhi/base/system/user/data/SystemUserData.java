package com.fzjianzhi.jianzhi.base.system.user.data;


import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

/**
 * SystemUserData
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/9
 */
@Data
@Cacheable
@Entity(name = "tb_system_user_data")
@EqualsAndHashCode(callSuper = true)
public class SystemUserData extends BaseEntity<Long> {
    private Integer age;
}
