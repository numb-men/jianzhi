package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.PointsGoodsResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * PointsGoodsException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class PointsGoodsException extends BaseException {
    public PointsGoodsException(PointsGoodsResultEnum pointsGoodsResultEnum) {
        super(pointsGoodsResultEnum);
    }
}
