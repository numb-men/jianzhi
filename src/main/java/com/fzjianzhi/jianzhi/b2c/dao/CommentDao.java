package com.fzjianzhi.jianzhi.b2c.dao;

import com.fzjianzhi.jianzhi.b2c.entity.Comment;
import com.fzjianzhi.jianzhi.base.mvc.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * CommentDao
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

@Repository
public interface CommentDao extends BaseDao<Comment, Long> {

}
