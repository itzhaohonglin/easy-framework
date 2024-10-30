package com.easy.framework.web.result;


import com.easy.framework.common.exception.BaseResultCodeEnum;
import com.easy.framework.common.exception.BizException;
import com.easy.framework.common.exception.IResultCode;

import java.util.Collection;
import java.util.Objects;

public class BizAssert {

    private BizAssert() {
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        if (expression) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

    public static void isNull(Object object, String message) {
        if (!Objects.isNull(object)) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notNull(Object object, IResultCode iResultCode) {
        if (Objects.isNull(object)) {
            throw new BizException(iResultCode);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (!Objects.isNull(collection) && !collection.isEmpty()) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new BizException(BaseResultCodeEnum.BIZ_ERROR.getCode(), message);
        }
    }

}
