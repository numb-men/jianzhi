package com.fzjianzhi.jianzhi.base.system.user.data;


import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import com.fzjianzhi.jianzhi.base.system.config.SystemDict;
import com.fzjianzhi.jianzhi.base.system.config.SystemDictItem;
import com.fzjianzhi.jianzhi.base.system.config.UseSystemDict;
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
@UseSystemDict
@Entity(name = "tb_system_user_data")
@EqualsAndHashCode(callSuper = true)
public class SystemUserData extends BaseEntity<Long> {

    private Integer age;

    @SystemDict(name = "sex", comment = "性别", items = {
            @SystemDictItem(value = "男", icon = "man.png"),
            @SystemDictItem(value = "女", icon = "women.png")
    })
    private Integer sex;
}
