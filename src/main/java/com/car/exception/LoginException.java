package com.car.exception;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 登录异常类
 */
public class LoginException extends Exception{
    public LoginException(String message)
    {
        super(message);
    }
    public LoginException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
