package com.car.exception;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 网络异常类
 */
public class InternetException extends Exception{
    public InternetException(String message)
    {
        super(message);
    }
    public InternetException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
