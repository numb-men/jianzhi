package com.fzjianzhi.jianzhi.b2c.dao;

import com.fzjianzhi.jianzhi.b2c.entity.UserMessage;
import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * UserMessageDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Repository
public interface UserMessageDao extends BaseDao<UserMessage, Long> {

}
