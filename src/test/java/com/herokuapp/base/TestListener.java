package com.herokuapp.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

        Logger log;
        String testName;
        String testMethodName;

        @Override
        public void onTestSkipped(ITestResult result) {
            ITestListener.super.onTestSkipped(result);
        }

        @Override
        public void onFinish(ITestContext context) {
            log.info("[ALL: " + testName + " FINISHED]");
        }

        @Override
        public void onStart(ITestContext context) {
            this.testName = context.getCurrentXmlTest().getName();
            this.log = LogManager.getLogger(testName);
            log.info("[TEST: " + testName + " STARTED]");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        }

        @Override
        public void onTestFailure(ITestResult result) {
            log.info("[Test: " + testMethodName + " failed]");
        }

        @Override
        public void onTestStart(ITestResult result) {
            this.testMethodName = result.getMethod().getMethodName();
            log.info("[Starting: " + testMethodName + "]");
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            log.info("[Test: " + testMethodName + " passed]");
        }
}

