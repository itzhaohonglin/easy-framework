package com.easy.framework.common.exception;

public interface IResultCode {
    /**
     * 返回的错误码.
     *
     * @return String
     */
    String getCode();

    /**
     * 返回的错误信息.
     *
     * @return String
     */
    String getMessage();
}
