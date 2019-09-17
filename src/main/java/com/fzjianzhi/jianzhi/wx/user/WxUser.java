package com.fzjianzhi.jianzhi.wx.user;


import com.fzjianzhi.jianzhi.base.mvc.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * WxUser
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */
@Data
@Entity(name = "tb_wx_user")
@EqualsAndHashCode(callSuper = true)
public class WxUser extends BaseEntity<Long> {

    @NotBlank
    private String openId;

    @NotBlank
    private String avatarUrl;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @NotNull
    private Integer gender;

    @NotBlank
    private String language;

    @NotBlank
    private String nickName;

    @NotBlank
    private String province;

}
