package com.curso.selenium.mx;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.checkLink.test.CheckLink;

public class Ejemplo2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		// Declaracion de wait implicito
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.switchTo().frame("iframeResult");

		WebElement btn = driver.findElement(By.xpath("/html/body/button"));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		btn.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertWindow = driver.switchTo().alert();
		String alertText = alertWindow.getText();
		System.out.println(alertText);
		alertWindow.sendKeys("Freddy");
		alertWindow.accept();

		String finalText = driver.findElement(By.id("demo")).getText();
		System.out.println(finalText.contains("Freddy") ? finalText : "Prueba Fallida !");

		try {

		} catch (NoSuchElementException ne) {
			System.err.println("No se encontro el WebElement" + ne.getMessage());
		} catch (NoSuchFrameException nf) {
			System.err.println("No se encontro el Frame" + nf.getMessage());
		} catch (NoAlertPresentException na) {
			System.err.println("No se encontro la Alerta" + na.getMessage());
		} catch (TimeoutException te) {
			System.err.println("Tiempo de espera Excedido" + te.getMessage());
		}

		catch (WebDriverException we) {
			System.err.println("WebDriver Falló" + we.getMessage());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			driver.quit();
		}
	}

}
