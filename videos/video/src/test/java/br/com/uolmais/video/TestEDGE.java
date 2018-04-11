package br.com.uolmais.video;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.uolmais.generic.TestGeneric;

public class TestEDGE extends TestPlayVideoUnico {

	@Override
	public WebDriver createDriver() {
		
		System.setProperty("webdriver.ie.driver", "C:/Users/vrt_coliveira/Documents/videos/video/MicrosoftWebDriver.exe");	
		return new EdgeDriver();
	}

}
