package com.fzjianzhi.jianzhi.base.mvc;


import com.fzjianzhi.jianzhi.base.exception.common.BaseException;
import com.fzjianzhi.jianzhi.base.exception.enums.BaseResultEnum;
import com.fzjianzhi.jianzhi.base.system.user.SystemCurrentUser;
import com.fzjianzhi.jianzhi.base.utils.BaseUtil;
import com.fzjianzhi.jianzhi.wx.user.WxCurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * UserAuditor
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/9
 */
@Slf4j
@Configuration
public class UserAuditor implements AuditorAware<Long> {

    @Resource
    private BaseUtil baseUtil;


    /**
     * 通过对当前请求用户获取数据，来设置createBy、updateBy属性
     *
     * @return Optional<Long>
     */
    @Override
    public Optional<Long> getCurrentAuditor() {
        Long userId = null;
        if (baseUtil.currentUserIsAdmin() || baseUtil.currentUserIsSystemUser()) {
            SystemCurrentUser currentUser = baseUtil.getSystemCurrentUser();
            userId = currentUser.getId();
        }
        else if (baseUtil.currentUserIsWxUser()) {
            WxCurrentUser wxCurrentUser = baseUtil.getWxCurrentUser();
            if (wxCurrentUser.getId() == null && wxCurrentUser.getWxUser() == null
                    && wxCurrentUser.getWxOpenId() != null) {
                // first save
                userId = baseUtil.getSystemAdmin().getId();
            }
            else {
                userId = wxCurrentUser.getId();
            }
        }
        if (userId == null) {
            throw new BaseException(BaseResultEnum.SET_AUDITOR_FAIL);
        }
        return Optional.of(userId);
    }
}
