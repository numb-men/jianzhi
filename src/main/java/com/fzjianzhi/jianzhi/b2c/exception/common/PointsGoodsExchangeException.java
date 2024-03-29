package com.fzjianzhi.jianzhi.b2c.exception.common;

import com.fzjianzhi.jianzhi.b2c.exception.enums.PointsGoodsExchangeResultEnum;
import com.fzjianzhi.jianzhi.base.exception.common.BaseException;

/**
 * PointsGoodsExchangeException
 *
 * @author hengyumo
 * @version 1.0
 * @since 2019/9/17
 */

public class PointsGoodsExchangeException extends BaseException {
    public PointsGoodsExchangeException(PointsGoodsExchangeResultEnum pointsGoodsExchangeResultEnum) {
        super(pointsGoodsExchangeResultEnum);
    }
}
