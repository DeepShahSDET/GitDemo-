package com.example.tests;

import org.testng.annotations.Test;

import com.example.infrastructure.BaseTest;
import com.example.objects.ContactUsPage;

public class ContactUsTest extends BaseTest {

	@Test
	public void contactUS() {
		ContactUsPage page = new ContactUsPage(driver);
		test.info("Test case started for Contact us ");
		page.setName().setPhone().setEmail().setRequirement().clickAttachFile().clickSubmit();
	}

	@Test
	public void careerContactUS() {
		ContactUsPage page = new ContactUsPage(driver);
		test.info("Test case started for Career contact us ");
		page.clickCarrer();
	}

}
