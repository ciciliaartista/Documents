package br.com.uolmais.video;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome extends TestGeneric {

	@Override
	public WebDriver createDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vrt_coliveira/Documents/videos/video/chromedriver.exe");	
		return new ChromeDriver();
	}

}
