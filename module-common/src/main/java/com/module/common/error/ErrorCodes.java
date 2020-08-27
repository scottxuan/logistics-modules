package com.module.common.error;

import com.scottxuan.base.error.ErrorCode;
import com.scottxuan.base.error.IError;

/**
 * @author : scottxuan
 */
public interface ErrorCodes extends com.scottxuan.base.error.ErrorCodes {
    /**
     * accessToken过期
     */
    IError ACCESS_TOKEN_TIME_OUT = new ErrorCode(801, "access.token.time.out");
    /**
     * 禁用ip
     */
    IError IP_IN_BLACK_LIST = new ErrorCode(802, "ip.in.black.list");
    /**
     * 账户异常10401-10500
     */
    IError WE_CHAT_APPLET_LOGIN_ERROR = new ErrorCode(10401, "wechat.applet.login.error");
}
