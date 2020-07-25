package pruebaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		WebDriver driver;
		
		// se declara la variable 
		String url = "https://www.google.cl/";
		
		//indicar la ubicacion
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

		//abrir el navegador
		driver = new ChromeDriver();
		driver.get(url);
		
	}

}
