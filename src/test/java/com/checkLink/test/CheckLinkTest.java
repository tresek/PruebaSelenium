package com.checkLink.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CheckLinkTest {
	WebDriver driver;
	CheckLink page;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		page = new CheckLink(driver);
		driver.get("https://www-qa-new.tegere.info/");
	}

	@Test
	public void checkLink() {
		assertTrue(page.checkPage(), "Link erroneros");
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
