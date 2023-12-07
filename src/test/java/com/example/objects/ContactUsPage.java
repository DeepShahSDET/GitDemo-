package com.example.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.propertiesconfig.PropertiesFile;

import static com.example.infrastructure.Helper.*;

import java.io.IOException;
import java.time.Duration;

public class ContactUsPage {
	WebDriver driver;
	Duration timeout;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// System.out.println("Driver" + driver);
	}

	@FindBy(css = "input[name='Name']")
	private WebElement nameField;

	@FindBy(css = "input[name='PhoneNumber']")
	private WebElement phoneField;

	@FindBy(css = "input[name='EmailAddress']")
	private WebElement emailField;

	@FindBy(css = "textarea[name='DescribeYourRequirement']")
	private WebElement requirementField;

	@FindBy(css = "span[data-name='file-801']")
	private WebElement attachFile;

	@FindBy(id = "wpcf-custom-btn-0")
	private WebElement submitBtn;

	@FindBy(id = "menu-item-22240")
	private WebElement careerBtn;

	public ContactUsPage setName() {
		nameField.sendKeys("Atharva");
		return this;
	}

	public ContactUsPage setPhone() {
		phoneField.sendKeys("9157835764");
		return this;
	}

	public ContactUsPage setEmail() {
		emailField.sendKeys("Atharva@gmail.com");
		return this;
	}

	public ContactUsPage setRequirement() {
		scrollToElement(driver, requirementField);
		requirementField.sendKeys("I want to create website for my own business");
		return this;
	}

	public ContactUsPage clickAttachFile() {
		attachFile.click();
		try {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String pathForEXE = PropertiesFile.projectPath + "/AutoIT/FileUploadScript.exe";
			pathForEXE = pathForEXE.replace("/", "\\");
			Runtime.getRuntime().exec(pathForEXE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ContactUsPage clickSubmit() {
		submitBtn.click();
		return this;
	}

	public ContactUsPage clickCarrer() {
		careerBtn.click();
		waitForElementToBeVisibleAndClickable(driver, careerBtn, timeout.ofSeconds(10));
		return this;
	}

}
