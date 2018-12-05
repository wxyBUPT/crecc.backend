package com.crecc.sale.service.exception;

/**
 * Created by xiyuanbupt on 2018/11/30.
 * 无法删除资源
 */
public class CannotDeleteResourceException extends Exception{
    public CannotDeleteResourceException(String message) {
        super(message);
    }
}
