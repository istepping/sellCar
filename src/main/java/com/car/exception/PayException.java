package com.car.exception;

/**
 * @author 姜志刚&张兴邦 on 2018/7/12
 * @version 1.0
 * apiNote 支付异常类
 */
public class PayException extends Exception {
    public PayException(String message) {
        super(message);
    }

    public PayException(String message, Throwable cause) {
        super(message, cause);
    }
}
