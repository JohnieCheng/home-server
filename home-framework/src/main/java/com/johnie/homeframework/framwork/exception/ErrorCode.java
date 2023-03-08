package com.johnie.homeframework.framwork.exception;

import lombok.Getter;

/**
 * * 规定:
 * * #1表示成功
 * * #1001～1999 区间表示参数错误
 * * #2001～2999 区间表示用户错误
 * * #3001～3999 区间表示接口异常
 */
@Getter
public enum ErrorCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    UNAUTHORIZED(401, "还未授权，不能访问"),

    /* 默认失败 */
    /**
     * 失败
     */
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试"),

    /* 参数错误：1000～1999 */

    /**
     * 参数无效
     */
    PARAM_NOT_VALID(1001, "参数无效"),
    /**
     * 参数为空
     */
    PARAM_IS_BLANK(1002, "参数为空"),
    /**
     * 参数类型错误
     */
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    /**
     * 参数缺失
     */
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /* 用户错误 */

    /**
     * 用户未登录
     */
    USER_NOT_LOGIN(2001, "用户未登录"),
    /**
     * 账号已过期
     */
    USER_ACCOUNT_EXPIRED(2002, "账号已过期"),
    /**
     * 密码错误
     */
    USER_CREDENTIALS_ERROR(2003, "密码错误"),
    /**
     * 密码过期
     */
    USER_CREDENTIALS_EXPIRED(2004, "密码过期"),
    /**
     * 账号不可用
     */
    USER_ACCOUNT_DISABLE(2005, "账号不可用"),
    /**
     * 账号被锁定
     */
    USER_ACCOUNT_LOCKED(2006, "账号被锁定"),
    /**
     * 账号不存在
     */
    USER_ACCOUNT_NOT_EXIST(2007, "账号不存在"),
    /**
     * 账号已存在
     */
    USER_ACCOUNT_ALREADY_EXIST(2008, "账号已存在"),
    /**
     * 账号下线
     */
    USER_ACCOUNT_USE_BY_OTHERS(2009, "账号下线"),

    /* 业务错误 */

    /**
     * 没有权限
     */
    NO_PERMISSION(3001, "没有权限");
    private final Integer code;
    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     * @param code 错误码
     * @return 错误消息
     */
    public static String getErrorMessageByCode(Integer code) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.getCode().equals(code)) {
                return errorCode.getMessage();
            }
        }
        return null;
    }
}