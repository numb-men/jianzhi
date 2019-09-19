package com.fzjianzhi.jianzhi.base.system.dict;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * SystemDictEntity
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/18
 */
@Data
@Cacheable
@EqualsAndHashCode(callSuper = true)
@Entity(name = "tb_system_dict")
public class SystemDictEntity extends BaseEntity<Long> {

    private String name;
    private String comment;
    private String dictIcon;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tb_system_dict_dict_item", joinColumns = @JoinColumn(name = "system_dict_id"),
            inverseJoinColumns = @JoinColumn(name = "system_dict_item_id"))
    private List<SystemDictItemEntity> items;
}
