package com.curso.selenium.mx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ParameterByTestContext {

	WebDriver driver;

	@BeforeTest(groups = { "A", "B" })
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://google.com/");
	}

	@AfterTest(groups = { "A" })
	public void tearDown() {
		driver.quit();
	}

//	@DataProvider(name = "SearchProvider")
//	public Object[][] getDataFromDataProvider(){
//		return new Object[][] {
//			{"Fernardo", "Google"},
//			{"Luis", "Yahoo"},
//			{"Sara", "Gmail"},
//			{"Lorena", "Amazon"}
//		};

//	}
	@Test(dataProvider = "SearchProvider", groups = "A")
	public void testMethodA(String tester, String search) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(search);
		System.out.println("Welcome tester" + tester + " you search is --> " + search);
		Thread.sleep(2000);

		String testValue = searchText.getAttribute("value");
		System.out.println("testValue es -->" + testValue + " es igual a search");
		searchText.clear();

		// Verificar
		Assert.assertTrue(testValue.equals(search));
	}

	@Test(dataProvider = "SearchProvider", groups = "B")
	public void testMethodB(String searchKeys) throws InterruptedException {
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKeys);
		Thread.sleep(2000);

		String testValue = searchText.getAttribute("value");
		System.out.println("testValue es -->" + testValue + " es igual a search");
		searchText.clear();

		// Verificar
		Assert.assertTrue(testValue.equals(searchKeys));
	}

	@DataProvider(name = "SearchProvider")
	public Object[][] getDataFromDataProvider(ITestContext c) {
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			if (group.equals("A")) {
				groupArray = new Object[][] { { "Isabel", "Google" }, { "Ernesto", "Yahoo" }, { "Gabriela", "gmail" },
						{ "Pedro", "visual" } };
				break;
			} else if (group.equals("B")) {
				groupArray = new Object[][] { { "Chile" }, { "Peru" }, { "Bolivia" },

				};
			}
			break;

		}
		return groupArray;

	}
}
