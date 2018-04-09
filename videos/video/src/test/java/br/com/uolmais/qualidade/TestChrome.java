package br.com.uolmais.qualidade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome extends TestQualidade {

	@Override
	public WebDriver createDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vrt_coliveira/Documents/videos/video/chromedriver.exe");	
		return new ChromeDriver();
	}

}
