package com.fzjianzhi.jianzhi.base.system.file;

import com.fzjianzhi.jianzhi.base.annotation.SystemUserAuth;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.system.config.SystemResource;
import com.fzjianzhi.jianzhi.base.system.config.SystemResourceClass;
import com.fzjianzhi.jianzhi.base.system.exception.common.SystemException;
import com.fzjianzhi.jianzhi.base.system.exception.enums.SystemResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * FileController
 * TODO
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/19
 */

@Slf4j
@RestController
@RequestMapping("/system/file")
@SystemResourceClass(resourceName = "file", comment = "文件", parentResource = "system")
public class FileController {

    @Resource
    private FileService fileService;

    @SystemUserAuth
    @PostMapping("/upload")
    @SystemResource(comment = "文件上传")
    public Result upload(@RequestParam MultipartFile file) {
        fileService.upload(file);
        return Result.success();
    }

    @SystemUserAuth
    @PostMapping(value = "upload/many")
    @SystemResource(comment = "多文件上传")
    public Result uploadMany(HttpServletRequest request) {
        fileService.uploadMany(request);
        return Result.success();
    }
}
