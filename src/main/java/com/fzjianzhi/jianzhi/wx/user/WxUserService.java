package com.fzjianzhi.jianzhi.wx.user;


import com.fzjianzhi.jianzhi.base.cache.EhcacheCache;
import com.fzjianzhi.jianzhi.base.mvc.BaseService;
import com.fzjianzhi.jianzhi.base.utils.BaseUtil;
import com.fzjianzhi.jianzhi.base.utils.TokenUtil;
import com.fzjianzhi.jianzhi.wx.utils.WxUtils;
import com.fzjianzhi.jianzhi.wx.utils.vo.WxSessionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * WxUserService
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */
@Service
public class WxUserService extends BaseService<WxUser, Long> {

    @Resource
    private WxUtils wxUtils;

    @Resource
    private BaseUtil baseUtil;

    @Resource
    private WxUserDao wxUserDao;


    public String login(String code) {
        WxSessionVo wxSessionVo = wxUtils.login(code);
        String key = "wx_" + wxSessionVo.getOpenid();
        EhcacheCache.setValue("wxSessionCache", key , wxSessionVo);
        return TokenUtil.createToken(key, wxSessionVo.getSession_key());
    }

    public void saveInfo(WxUserInfoDto wxUserInfoDto) {
        WxUser wxUser = null;
        String openId = "";
        if (baseUtil.currentUserIsWxUser()) {
            WxCurrentUser wxCurrentUser = baseUtil.getWxCurrentUser();
            if (wxCurrentUser.getId() == null) {
                openId = wxCurrentUser.getWxOpenId();
            }
            else {
                wxUser = wxCurrentUser.getWxUser();
            }
        }
        else if (wxUserInfoDto.getOpenId() != null) {
            wxUser = wxUserDao.findByOpenId(wxUserInfoDto.getOpenId());
            if (wxUser == null) {
                openId = wxUserInfoDto.getOpenId();
            }
        }
        else {
            throw new WxUserException(WxUserResultEnum.SAVE_USER_INFO_FAIL);
        }
        if (wxUser == null) {
            wxUser = new WxUser();
        }
        BeanUtils.copyProperties(wxUserInfoDto, wxUser);
        wxUser.setOpenId(openId);
        save(wxUser);
    }
}
