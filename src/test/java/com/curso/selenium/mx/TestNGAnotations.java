package com.curso.selenium.mx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGAnotations {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Este metodo se ejecuta antes que toda la suite de prueba !");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Este metodo se enjecuta antes de las pruebas @Test !!");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Se ejecuta antes de la clase");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Se ejecuta antes de cada metodo de prueba");
	}
	@Test
	public void test() {
		System.out.println("Caso de prueba 1");
	}
	@Test
	public void test2() {
		System.out.println("Caso de prueba 2");
	}	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Despues de cada metodo de prueba");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("Este metodo se ejecuta despues de la clase");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Este metodo se ejecuta despues de todas las pruebas");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Se ejecuta despues de suite de prueba");
	}
}
