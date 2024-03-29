package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Comment
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_comment")
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity<Long> {

    private Long userId;

    private String content;
}
