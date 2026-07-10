package com.retry.core;

import com.retry.interfaces.Retryable;
import com.retry.exceptions.*;

public class SampleTask implements Retryable {

    private int failCount = 0;

    public void execute() throws Exception {

        if (failCount < 2) {
            failCount++;
            throw new TemporaryException("Temporary failure");
        }

        if (failCount == 2) 
        {
            failCount++;
            throw new TimeoutException("Operation timed out");
        }

        System.out.println("Task executed successfully");
    }
}