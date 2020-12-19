package com.ssm.controller.exception;

public class CustomerException extends Exception {

    //异常信息
    public String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerException(String message) {
        super(message);
        this.message = message;
    }
}
