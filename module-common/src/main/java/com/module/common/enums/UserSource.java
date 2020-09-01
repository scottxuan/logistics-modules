package com.module.common.enums;

/**
 * @author : pc
 * @date : 2020/9/1
 */
public enum UserSource {
    SYS(1),
    CUS(2),
    ;

    public int source;

    UserSource(int source) {
        this.source = source;
    }

    public int getSource() {
        return source;
    }

    public static UserSource getUserSource(int source){
        for (UserSource userSource : UserSource.values()) {
            if (userSource.getSource() == source) {
                return userSource;
            }
        }
        return null;
    }
}
