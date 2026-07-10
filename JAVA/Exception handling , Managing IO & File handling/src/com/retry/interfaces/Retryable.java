package com.retry.interfaces;

public interface Retryable {
    void execute() throws Exception;
}