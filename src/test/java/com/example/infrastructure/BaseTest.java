package com.example.infrastructure;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.propertiesconfig.PropertiesFile;

public class BaseTest {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentSparkReporter spark;

	@BeforeSuite
	public void setUp() throws IOException {
		driver = Helper.getDriver(PropertiesFile.getProperties("browser"));
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(PropertiesFile.projectPath + "/automation-report/TestAutomation.html");
		extent.attachReporter(spark);
		driver.get(PropertiesFile.getProperties("url"));
		deleteAndCreateScreenShotFolder();
	}

	@BeforeMethod
	public void startTest(Method method) {
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void endTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = captureScreenshot(driver, result.getName());
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip(result.getThrowable());
		} else {
			test.pass("Test passed");
		}
		extent.flush();
	}

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String folderPath = PropertiesFile.projectPath + "/Screenshots/";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = folderPath + screenshotName + "_" + dateName + "_.png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	public static void deleteAndCreateScreenShotFolder() {
		String folderPath = PropertiesFile.projectPath + "/Screenshots/";
		File folder = new File(folderPath);
		if (folder.exists()) {
			try {
				FileUtils.deleteDirectory(folder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		folder.mkdir();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
}
