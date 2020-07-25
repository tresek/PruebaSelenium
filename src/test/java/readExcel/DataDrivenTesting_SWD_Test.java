package readExcel;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class DataDrivenTesting_SWD_Test {
	private WebDriver driver;
	private ReadExcelFile readFile;
	private WriteExcelFile writeFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filePath = "C:\\Users\\APIUXNB1024\\Desktop\\test.xlsx";
		String searchText = readFile.getCellValue(filePath, "Hoja1", 0, 0);
		String text ="hola";

		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();

		System.out.println("El resultado del texto es: " + resultText);
		writeFile.writeCellValue(filePath, "Hoja1", 0, 1, resultText);
		// readFile.readExcel(filePath, "Hoja1");
		System.out.println("se escribe en excel");
		Assert.assertEquals(searchText, text);

	}

	@Test
	public void test1() throws IOException {
		String filePath = "C:\\Users\\APIUXNB1024\\Desktop\\test.xlsx";
		String searchText = readFile.getCellValue(filePath, "Hoja1", 1, 0);

		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();

		System.out.println("El resultado del texto es: " + resultText);
		writeFile.writeCellValue(filePath, "Hoja1", 1, 1, resultText);
		// readFile.readExcel(filePath, "Hoja1");
		System.out.println("se escribe en excel");

	}
	@Test
	public void test2() throws IOException {
		String filePath = "C:\\Users\\APIUXNB1024\\Desktop\\test.xlsx";
		String searchText = readFile.getCellValue(filePath, "Hoja1", 2, 0);

		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		String resultText = driver.findElement(resultTextLocator).getText();

		System.out.println("El resultado del texto es: " + resultText);
		writeFile.writeCellValue(filePath, "Hoja1", 2, 1, resultText);
		// readFile.readExcel(filePath, "Hoja1");
		System.out.println("se escribe en excel");

	}

}
