package com.example.logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener {
	public void onTestStart(ITestResult result) {
		Log.info("");
		Log.info("-------------------------- " + result.getMethod().getMethodName().toUpperCase()
				+ " Started -------------------------- ");
		// Log.info(result.getMethod().getMethodName().toUpperCase() + " started");
	}

	public void onTestSuccess(ITestResult result) {
		Log.info(result.getMethod().getMethodName().toUpperCase() + " passed");
		Log.info("-------------------------- " + result.getMethod().getMethodName().toUpperCase()
				+ " Ended --------------------------");
		Log.info("");
	}

	public void onTestFailure(ITestResult result) {
		Log.info("Failed due to - " + result.getThrowable());
		Log.info("-------------------------- " + result.getMethod().getMethodName().toUpperCase()
				+ " Ended --------------------------");
		Log.info("");
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("Skipped because of - " + result.getThrowable());
		Log.info("-------------------------- " + result.getMethod().getMethodName().toUpperCase()
				+ " Ended --------------------------");
		Log.info("");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		Log.info("====================================================");
		Log.info("Start :-" + context.getName());
		Log.info("====================================================");

	}

	public void onFinish(ITestContext context) {
		Log.info("====================================================");
		Log.info("Finish :-" + context.getName());
		Log.info("====================================================");
	}
}