package com.fzjianzhi.jianzhi.base.system.user.data;


import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import com.fzjianzhi.jianzhi.base.system.config.SystemDict;
import com.fzjianzhi.jianzhi.base.system.config.SystemDictItem;
import com.fzjianzhi.jianzhi.base.system.config.UseSystemDict;
import com.fzjianzhi.jianzhi.base.system.dict.SystemDictDeserializer;
import com.fzjianzhi.jianzhi.base.system.dict.SystemDictSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * SystemUserData
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/9
 */
@Data
@UseSystemDict
@Entity(name = "tb_system_user_data")
@EqualsAndHashCode(callSuper = true)
public class SystemUserData extends BaseEntity<Long> {

    private Integer age;

    @SystemDict(name = "sex", comment = "性别", items = {
            @SystemDictItem(value = "男", icon = "man.png"),
            @SystemDictItem(value = "女", icon = "women.png")
    })
    @JsonDeserialize(using = SystemDictDeserializer.class)
    @JsonSerialize(using = SystemDictSerializer.class)
    private Integer sex;
}
