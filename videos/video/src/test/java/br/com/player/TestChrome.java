package br.com.player;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome extends TestPlayer {

	@Override
	public WebDriver createDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/vrt_coliveira/Documents/videos/video/chromedriver.exe");	
		return new ChromeDriver();
	}

}
