package com.retry.exceptions;

public class TimeoutException extends Exception {
    public TimeoutException(String msg) {
        super(msg);
    }
}