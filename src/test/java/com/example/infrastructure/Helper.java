package com.example.infrastructure;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	public static WebDriver getDriver(String browser) {
		WebDriverManager manager = WebDriverManager.getInstance(browser);
		manager.clearResolutionCache()./* clearDriverCache(). */setup();
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: " + browser);
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void scrollToElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void waitForElementToBeVisibleAndClickable(WebDriver driver, WebElement ele,
			Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForElementToBeVisibleAndClickable(WebDriver driver, WebElement ele) {
		Duration defaultTimeoutInSeconds = Duration.ofSeconds(60);// Default timeout value
		waitForElementToBeVisibleAndClickable(driver, ele, defaultTimeoutInSeconds);
	}
}
