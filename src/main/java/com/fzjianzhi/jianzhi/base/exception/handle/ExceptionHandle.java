package com.fzjianzhi.jianzhi.base.exception.handle;


import com.fzjianzhi.jianzhi.base.exception.common.BaseException;
import com.fzjianzhi.jianzhi.base.exception.enums.BaseResultEnum;
import com.fzjianzhi.jianzhi.base.request.BaseRequest;
import com.fzjianzhi.jianzhi.base.result.Result;
import com.fzjianzhi.jianzhi.base.result.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * ExceptionHandel
 * 全局异常处理类
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/4/17
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof BaseException) {
            // 系统内部异常
            BaseException baseException = (BaseException) e;
            return error(baseException.getResultEnum());
        }
        else if (e instanceof MissingServletRequestParameterException){
            // 缺少参数
            return error(BaseRequest.MISSING_PARAM, e.getMessage());
        }
        else if (e instanceof MissingServletRequestPartException) {
            // 缺少参数
            return error(BaseRequest.MISSING_REQUEST_PART, e.getMessage());
        }
        else if (e instanceof HttpMessageNotReadableException) {
            // json字典解析错误
            HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) e;
            return error(BaseResultEnum.UN_MAPPING_JSON.getCode(),
                    BaseResultEnum.UN_MAPPING_JSON.getMessage());
        }
        else if (e instanceof ConstraintViolationException){
            // 表单验证不通过
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> constraintViolations
                    = constraintViolationException.getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
            StringBuilder messages = new StringBuilder();
            while (iterator.hasNext()) {
                ConstraintViolation<?> constraintViolation = iterator.next();
                messages.append(constraintViolation.getMessage()).append('\n');
            }

            return error(BaseRequest.PARAM_VALIDATE_FAIL, messages.toString());
        }
        else if (e instanceof BindException){
            // @Valid表单验证不通过
            BindException bindException = (BindException)e;
            List<ObjectError> errors = bindException.getAllErrors();
            StringBuilder messages = new StringBuilder();
            for (ObjectError objectError : errors){
                messages.append(objectError.getDefaultMessage()).append('\n');
            }

            return error(BaseRequest.FORM_VALIDATE_FAIL, messages.toString());
        }
        else if (e instanceof HttpRequestMethodNotSupportedException){
            // 请求方式不支持
            HttpRequestMethodNotSupportedException exception = (HttpRequestMethodNotSupportedException)e;
            return error(BaseRequest.HTTP_REQUEST_METHOD_NOT_SUPPORTED, exception.getMessage());
        }
        else if (e instanceof MethodArgumentTypeMismatchException){
            // 请求参数格式不正确
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException)e;
            return error(BaseRequest.METHOD_ARGUMENT_TYPE_MISMATCH, exception.getMessage());
        }
        else if (e instanceof MultipartException) {
            // 请求文件格式不正确
            MultipartException multipartException = (MultipartException) e;
            return error(BaseRequest.MULTIPART_EXCEPTION, multipartException.getMessage());
        }
        else {
            logger.error("!!!系统异常!!!", e);
            return error(BaseResultEnum.UNKNOWN_ERROR);
        }
    }

    private Result error(ResultEnum resultEnum) {
        logger.info(String.valueOf(resultEnum.getCode()), resultEnum.getMessage());
        return Result.error(resultEnum);
    }

    private Result error(Integer code, String message) {
        logger.info(String.valueOf(code), message);
        return Result.error(code, message);
    }
}
