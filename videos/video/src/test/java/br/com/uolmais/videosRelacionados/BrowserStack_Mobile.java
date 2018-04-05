package br.com.uolmais.videosRelacionados;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import br.com.uolmais.buscas.TestBuscas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrowserStack_Mobile{

  public static final String USERNAME = "uolmais1"; 
  public static final String AUTOMATE_KEY = "81LodMsUgMp3YcqURgyJ";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  static int i = 1;
  



  public static void main(String[] args) throws Exception {
	  
	System.out.println("Setou o usuario "+USERNAME);  
   
  
    
    // Acesso vídeo normal
    
//    driver.get
//	("https://noticias.uol.com.br/cotidiano/ultimas-noticias/2018/03/21/dos-14-aos-93-anos-mulheres-querem-manter-vivo-legado-de-marielle.htm?autoplayMobile=true");
//	
//    System.out.println(driver.getTitle());
//    driver.quit();

  }


}