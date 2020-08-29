package com.module.system.enums;

/**
 * @author : pc
 * @date : 2020/8/18
 */
public enum SysConfigTypeEnum {
    TEXT(1),
    SINGLE(2),
    MULTIPLE(3),
    BOOLEAN(4),
    ;

    SysConfigTypeEnum(int type) {
        this.type = type;
    }

    public int type;
}
