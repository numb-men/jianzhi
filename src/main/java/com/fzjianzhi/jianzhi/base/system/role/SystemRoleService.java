package com.fzjianzhi.jianzhi.base.system.role;


import com.fzjianzhi.jianzhi.base.mvc.BaseService;
import com.fzjianzhi.jianzhi.base.system.exception.common.SystemException;
import com.fzjianzhi.jianzhi.base.system.exception.enums.SystemResultEnum;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceEntity;
import com.fzjianzhi.jianzhi.base.system.resource.SystemResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SystemRoleService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/11
 */
@Service
public class SystemRoleService extends BaseService<SystemRoleEntity, Long> {

    @Resource
    private SystemResourceService systemResourceService;

    private SystemRoleEntity systemRoleEntity;

    private SystemResourceEntity systemResourceEntity;


    public void addResource(Long roleId, Long resourceId) {
        setRoleAndResource(roleId, resourceId);
        systemRoleEntity.getResources().add(systemResourceEntity);
        save(systemRoleEntity);
    }

    public void deleteResource(Long roleId, Long resourceId) {
        setRoleAndResource(roleId, resourceId);
        systemRoleEntity.getResources().remove(systemResourceEntity);
        save(systemRoleEntity);
    }

    private void setRoleAndResource(Long roleId, Long resourceId) {
        systemRoleEntity = findOne(roleId).orElse(null);
        if (systemRoleEntity == null) {
            throw new SystemException(SystemResultEnum.ROLE_NOT_FOUND);
        }
        systemResourceEntity = systemResourceService.findOne(resourceId).orElse(null);
        if (systemResourceEntity == null) {
            throw new SystemException(SystemResultEnum.RESOURCE_NOT_FOUND);
        }
    }
}
