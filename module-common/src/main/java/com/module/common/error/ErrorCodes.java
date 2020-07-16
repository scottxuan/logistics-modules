package com.module.common.error;

import com.scottxuan.base.error.ErrorCode;
import com.scottxuan.base.error.IError;

/**
 * @author : scottxuan
 */
public interface ErrorCodes extends com.scottxuan.base.error.ErrorCodes {
    /**
     * 账户异常10401-10500
     */
    IError WE_CHAT_APPLET_LOGIN_ERROR = new ErrorCode(10401, "wechat.applet.login.error");
}
