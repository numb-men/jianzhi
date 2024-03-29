package com.fzjianzhi.jianzhi.base.system.role;


import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceEntity;
import com.fzjianzhi.jianzhi.base.system.user.SystemUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * SystemRoleEntity
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
@Data
@Cacheable
@EqualsAndHashCode(callSuper = true)
@Entity(name = "tb_system_role")
public class SystemRoleEntity extends BaseEntity<Long> {

    @NotBlank
    @Length(min = 2, max = 20, message = "角色名应该在2-10之间")
    private String name;


    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<SystemUser> users;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_system_role_resource", joinColumns = @JoinColumn(name = "system_role_id"),
            inverseJoinColumns = @JoinColumn(name = "system_resource_id"))
    private List<SystemResourceEntity> resources;

    @Override
    public String toString() {
        return "SystemRoleEntity{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
