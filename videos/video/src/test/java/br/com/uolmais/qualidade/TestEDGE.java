package br.com.uolmais.qualidade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestEDGE extends TestQualidade {

	@Override
	public WebDriver createDriver() {
		
		System.setProperty("webdriver.ie.driver", "C:/Users/vrt_coliveira/Documents/videos/video/MicrosoftWebDriver.exe");	
		return new EdgeDriver();
	}

}
