package com.fzjianzhi.jianzhi.b2c.dao;

import com.fzjianzhi.jianzhi.b2c.entity.Task;
import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * TaskDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Repository
public interface TaskDao extends BaseDao<Task, Long> {

}
