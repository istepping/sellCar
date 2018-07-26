package com.car.exception;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 权限异常类
 */
public class AuthorityException extends Exception{
    public AuthorityException(String message) {
        super(message);
    }
    public AuthorityException(String message, Throwable cause) {
        super(message, cause);
    }
}
