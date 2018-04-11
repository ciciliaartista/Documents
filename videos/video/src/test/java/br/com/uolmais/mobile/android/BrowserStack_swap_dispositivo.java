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

    caps.setCapability("browserName", "android");
    caps.setCapability("device", "Motorola Moto X 2nd Gen");
    caps.setCapability("realMobile", "true");
    caps.setCapability("os_version", "5.0");
  
    
    System.out.println("Denifiu o dispositivo "+caps.getBrowserName()); 
     
    driver = new RemoteWebDriver(new URL(URL), caps);
  
    //Entra no site do uolmais

    driver.get
	("http://mais.uol.com.br/view/dsirb7h509tj/homem-fica-ferido-apos-confusao-em-frente-ao-instituto-lula-0402CD1A3764C8A16326?types=A&webm=true");
	
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