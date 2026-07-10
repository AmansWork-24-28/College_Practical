package com.retry.main;

import java.util.Scanner;
import com.retry.core.*;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter max retry attempts:");
        int retries = sc.nextInt();

        RetryEngine engine = new RetryEngine(retries);
        SampleTask task = new SampleTask();

        engine.executeWithRetry(task);

        sc.close();
    }
}