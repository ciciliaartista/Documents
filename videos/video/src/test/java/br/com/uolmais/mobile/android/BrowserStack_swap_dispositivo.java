package br.com.uolmais.mobile.android;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import br.com.uolmais.buscas.TestBuscas;
import br.com.uolmais.generic.metodosGenericos;
import br.com.uolmais.video.TestPlayVideoUnico;
import br.com.uolmais.videosRelacionados.VideosRelacionados;

import java.net.URL;
import java.util.List;

public class BrowserStack_swap_dispositivo extends metodosGenericos{

  public static final String USERNAME = "uolmais1"; 
  public static final String AUTOMATE_KEY = "81LodMsUgMp3YcqURgyJ";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  static int i = 1;

  public static void main(String[] args) throws Exception {
	  
	System.out.println("Setou o usuario "+USERNAME);  

    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability ("browserstack.local", "true");
    
    System.out.println("Denifiu as capacidades "+caps); 

    caps.setCapability("browser", "Safari");
    caps.setCapability("browser_version", "13.0");
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "High Sierra");
    caps.setCapability("resolution", "1024x768");
  
    
    System.out.println("Denifiu o dispositivo "+caps.getBrowserName()); 
     
    driver = new RemoteWebDriver(new URL(URL), caps);
  
    //Entra no site do uolmais

    driver.get
	("http://mais.uol.com.br/view/bfc3becnpbdr/deborah-secco-diz-quando-se-sente-mais-sexy-e-fala-de-erros-fashion-04020C98306CC4A16326?types=A&");
	
	wait(15000);
	
	skipPublicidade();
	
	wait(15000);
	
	
	System.out.println(driver.getTitle());
    driver.quit();


  }

@Override
public WebDriver createDriver() {
	// TODO Auto-generated method stub
	return null;
}

}