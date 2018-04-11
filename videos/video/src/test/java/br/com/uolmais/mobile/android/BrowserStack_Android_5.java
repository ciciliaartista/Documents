package br.com.uolmais.mobile.android;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.uolmais.buscas.BuscaVideos;
import br.com.uolmais.buscas.TestBuscas;
import br.com.uolmais.generic.metodosGenericos;
import br.com.uolmais.videosRelacionados.TestVideosRelacionados;

import java.net.URL;
import java.util.List;

public class BrowserStack_Android_5 extends metodosGenericos{

  public static final String USERNAME = "uolmais1"; 
  public static final String AUTOMATE_KEY = "81LodMsUgMp3YcqURgyJ";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  static int i = 1;

  public static void main(String[] args) throws Exception {
	  
	System.out.println("Setou o usuario "+USERNAME);  

    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability ("browserstack.local", "true");
    
    System.out.println("Denifiu as capacidades "+caps); 

    caps.setCapability("browserName", "android");
    caps.setCapability("device", "Motorola Moto X 2nd Gen");
    caps.setCapability("realMobile", "true");
    caps.setCapability("os_version", "5.0");
    
    System.out.println("Denifiu o dispositivo "+caps.getBrowserName()); 
     
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
  
	//Entra no site do uolmais

    driver.get("http://mais.uol.com.br/view/91f2iyogwchf/honestidade-04029A3170E0910366?types=A&");
	wait(5000);
   System.out.println(driver.getTitle());
    driver.quit();

  }

@Override
public WebDriver createDriver() {
	// TODO Auto-generated method stub
	return null;
}

}