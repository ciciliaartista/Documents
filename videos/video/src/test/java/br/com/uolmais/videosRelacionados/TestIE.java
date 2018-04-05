package br.com.uolmais.videosRelacionados;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestIE extends TestVideosRelacionados {

	private DesiredCapabilities dc;
	@Override
	public WebDriver createDriver() {
		
		dc = DesiredCapabilities.internetExplorer();
		System.setProperty("webdriver.ie.driver", "C:/Users/vrt_coliveira/Documents/videos/video/IEDriverServer.exe");	
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		return new InternetExplorerDriver(dc);
	}

}
