package com.module.auth.enums;

import com.module.common.error.ErrorCodes;
import com.scottxuan.base.exception.BizException;

/**
 * @author : pc
 * @date : 2020/8/27
 */
public enum SystemType {
    /**
     * 后台管理系统
     */
    SYS(0),
    /**
     * 客户端系统
     */
    CUS(1),
    ;
    public int type;

    SystemType(Integer type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static SystemType findByType(Integer type){
        for (SystemType value : SystemType.values()) {
            if (value.type == type){
                return value;
            }
        }
        throw new BizException(ErrorCodes.ERROR_COMMON,"No Search Type!");
    }
}

