package com.fzjianzhi.jianzhi.b2c.dao;

import com.fzjianzhi.jianzhi.b2c.entity.CustomerUser;
import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * CustomerUserDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/16
 */
@Repository
public interface CustomerUserDao extends BaseDao<CustomerUser, Long> {
}
