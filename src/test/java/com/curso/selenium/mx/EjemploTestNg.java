package com.curso.selenium.mx;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploTestNg {
	String baseUrl = "http://newtours.demoaut.com/index.php";
	String expectResult = "";
	String actualResult = "";
	WebDriver driver;
	String chromePath = System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

	@BeforeTest // se ejecuta antes que cualquier cosa.
	public void lounchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}

	@BeforeMethod // Se ejecuta antes que las pruebas
	public void verifyHomeTitle() {
		expectResult = "Welcome: Mercury Tours";
		actualResult = driver.getTitle();

		Assert.assertEquals(actualResult, expectResult, "El Title NO es igual !!");

	}

	@AfterMethod // este metodo se repite
	public void goBackToHomePage() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		expectResult = "Register: Mercury Tours";
		actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectResult, "EL title NO es igual");
	}
	
	@Test (priority = 1, enabled = false)
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click();
		expectResult = "Under Construction: Mercury Tours";
		actualResult = driver.getTitle();
		Assert.assertEquals(actualResult, expectResult, "El title No es el mismo");
		
		
	}

}
