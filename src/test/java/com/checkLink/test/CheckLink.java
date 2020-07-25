package com.checkLink.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckLink {
	private WebDriver driver;

	public CheckLink(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String url = ""; // se guardan todos los link

		// se crean dos lista. Una para las url exitosas y erroneas
		List<String> linkError = new ArrayList<String>();
		List<String> linkOk = new ArrayList<String>();

		HttpURLConnection httpConection = null;
		int responseCode = 200;

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println(url + "La url No esta confiurada o esta vacia");
				continue;
			}
			try {
				httpConection = (HttpURLConnection) (new URL(url).openConnection()); // se abre la coneccion
				httpConection.setRequestMethod("HEAD");// solicita el metodo head
				httpConection.connect();
				responseCode = httpConection.getResponseCode(); // solicitamos el code de repuesta

				if (responseCode > 400) {
					System.out.println("ERROR DE LINK: --" + url);
					linkError.add(url);

				} else {
					System.out.println("LINK BUENOS: --" + url);
					linkOk.add(url);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("Link Validos" + linkOk.size());
		System.out.println("Link Erroneos" + linkError.size());

		if (linkError.size() > 0) {
			System.out.println("***************ERROR****************");
			for (int i = 0; i > linkError.size(); i++) {
				System.out.println(linkError.get(i));
			}
			return false;
		} else {
			return true;
		}
	}

}
//Codigo del 100 en adelante  son informacionales
//Codigo del 200 en adelante son exitosos
//Codigo 300 en adelante son elemento direccionados
//Codigo 400 en adelante son error del cliente
//Codigo 500 en adelante son error del server