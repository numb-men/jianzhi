package com.fzjianzhi.jianzhi.wx.user;

import com.fzjianzhi.jianzhi.base.annotation.PassAuth;
import com.fzjianzhi.jianzhi.base.mvc.BaseController;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.system.config.SystemConfig;
import com.fzjianzhi.jianzhi.base.system.config.SystemResource;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import com.fzjianzhi.jianzhi.wx.base.WxUserAuth;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * WxUserController
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/14
 */
@Validated
@RestController
@RequestMapping("/wx/user")
@SystemResourceClass(resourceName = "wxUser", comment = "微信用户管理",
        parentResource = SystemConfig.DEFAULT_RESOURCE_PARENT_CODE)
public class WxUserController extends BaseController<WxUserService, WxUser, Long> {

    @PassAuth
    @GetMapping("/login")
    @SystemResource(comment = "微信小程序登录")
    public Result login(@RequestParam String code) {
        return Result.success(baseService.login(code));
    }

    @WxUserAuth
    @PostMapping("/info")
    @SystemResource(comment = "保存或更新微信用户信息")
    public Result saveInfo(@Valid WxUserInfoDto wxUserInfoDto) {
        baseService.saveInfo(wxUserInfoDto);
        return Result.success();
    }
}
