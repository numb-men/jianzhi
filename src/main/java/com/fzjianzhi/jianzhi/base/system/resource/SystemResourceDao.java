package com.fzjianzhi.jianzhi.base.system.resource;


import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * SystemResourceDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/10
 */
@Repository
public interface SystemResourceDao extends BaseDao<SystemResourceEntity, Long> {

    Boolean existsByCode(String code);
}
