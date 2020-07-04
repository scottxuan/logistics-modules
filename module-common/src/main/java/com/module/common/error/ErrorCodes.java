package com.module.common.error;

import com.scottxuan.base.error.ErrorCode;
import com.scottxuan.base.error.IError;

/**
 * @author : scottxuan
 */
public interface ErrorCodes extends com.scottxuan.base.error.ErrorCodes {
    IError WE_CHAT_ERROR = new ErrorCode(10501, "we.chat.request.error");
}
