package com.fzjianzhi.jianzhi.b2c.entity;

import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * IndexPicture
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */

@Data
@Entity(name = "tb_index_picture")
@EqualsAndHashCode(callSuper = true)
public class IndexPicture extends BaseEntity<Long> {

    private Integer pictureIndex;

    private String url;

    private String pageLink;
}
