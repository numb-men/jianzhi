package com.fzjianzhi.jianzhi.base.system.dict;

import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * SystemDictDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/18
 */
@Repository
public interface SystemDictDao extends BaseDao<SystemDictEntity, Long> {

    SystemDictEntity findByName(String name);
}
