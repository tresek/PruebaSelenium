package com.checkLink.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPage {
	//CheckLink page;
		public static void main(String[] args) {
			CheckLink page;
			WebDriver driver;
			
		
			System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			page = new CheckLink(driver);
			driver.get("http://www.lun.com/");
			
			//Test
			assertTrue(page.checkPage(), "Link con errores");
			
				
	}

		private static void assertTrue(boolean checkPage, String string) {
			// TODO Auto-generated method stub
			
		}

}
