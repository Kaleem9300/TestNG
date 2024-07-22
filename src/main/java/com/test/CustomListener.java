package com.test;



import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed: " + result.getMethod().getMethodName());
    }
}