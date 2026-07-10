package com.retry.core;

import com.retry.interfaces.Retryable;
import com.retry.exceptions.*;
//import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RetryEngine {

    private int maxRetries;
    private int failureCount = 0;
    private int threshold = 3; // circuit breaker limit

    public RetryEngine(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    // Method to get timestamp
    private String getTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public void executeWithRetry(Retryable task) {
        int attempt = 0;
        int waitTime = 1;

        System.out.println("\n[" + getTimeStamp() + "] ===== RETRY ENGINE STARTED =====");

        while (attempt < maxRetries) {

            // Circuit Breaker Check BEFORE execution
            if (failureCount >= threshold) {
                System.out.println("\n[" + getTimeStamp() + "]  Circuit Breaker Activated!");
                System.out.println("[" + getTimeStamp() + "] Reason: Too many failures (" + failureCount + ")");
                return;
            }

            try {
                System.out.println("\n[" + getTimeStamp() + "] ➡ Attempt " + (attempt + 1) + " / " + maxRetries);

                task.execute();

                System.out.println("[" + getTimeStamp() + "]  Operation Successful!");
                System.out.println("[" + getTimeStamp() + "] ===== PROCESS COMPLETED =====");
                return; // stop if success
            } 
            catch (TemporaryException e) {
                System.out.println("[" + getTimeStamp() + "]  Retryable Error: " + e.getMessage());

                attempt++;
                failureCount++;

                // Exponential Backoff
                System.out.println("[" + getTimeStamp() + "]  Retrying after " + waitTime + " sec");
                waitTime *= 2;
            } 
            catch (TimeoutException e) {
                System.out.println("[" + getTimeStamp() + "]  Timeout Error: " + e.getMessage());
                System.out.println("[" + getTimeStamp() + "]  Stopping retries due to timeout.");
                return;
            } 
            catch (Exception e) {
                System.out.println("[" + getTimeStamp() + "]  Non-retryable Error: " + e.getMessage());
                return;
            }
        }

        // If max retries reached
        System.out.println("\n[" + getTimeStamp() + "]  Max retries reached. Operation failed.");
    }
}