package br.com.uolmais.mobile.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.uolmais.buscas.TestBuscas;
import br.com.uolmais.video.TestGeneric;

import java.net.URL;
import java.util.List;

public class BrowserStack_ios_11 extends TestGeneric{

  public static final String USERNAME = "uolmais1"; 
  public static final String AUTOMATE_KEY = "81LodMsUgMp3YcqURgyJ";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  static int i = 1;

  public static void main(String[] args) throws Exception {
	  
	System.out.println("Setou o usuario "+USERNAME);  

    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability ("browserstack.local", "true");
    
    System.out.println("Denifiu as capacidades "+caps); 

    caps.setCapability("browserName", "iPhone");
    caps.setCapability("device", "iPhone 8");
    caps.setCapability("realMobile", "true");
    caps.setCapability("os_version", "11.0");
    
    System.out.println("Denifiu o dispositivo "+caps.getBrowserName()); 
     
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
  
//    while (i<=2) {
//		
//		//Entra no site do uolmais
//		driver.get("http://mais.uol.com.br/");
//		
//		//Seleciona os vídeos mais recentes
//		WebElement elem = driver.findElement(By.xpath("//*[@id=\"mais-recentes\"]/div/div/div/a/h2/strong"));
//		elem.click();
//				
//		//Seleciona o primeiro vídeo da fila
//		
//		//Chrome
//		WebElement video1 = driver.findElement(By.xpath("//*[@id=\"zeitgeists\"]/li"+"["+i+"]"));
//		
//		//IE
//		//WebElement video1 = driver.findElement(By.cssSelector("#zeitgeists>li:nth-child(1)"));		
//		
//		video1.click();	
//
//		System.out.println("Selecionou o primeiro da fila" +i);
//		
//		//Seleciona a primeira tag
//		WebElement valorTagBusca = driver.findElement(By.className("tgw"));
//		System.out.println("Tag "+valorTagBusca.getText());
//				
//		System.out.println("Selecionou a primeira tag" +i);
//    
//    
//    	//Seleciona o mediaID
//	
//  		List<WebElement> elements = driver.findElements(By.cssSelector(".uolplayer"));
//  		
//          for (WebElement el : elements) {
//
//          	System.out.println("MediaId "+el.getAttribute("mediaid") + " ID: " + el.getAttribute("id"));
//
//          }
//		
//		//Preenche o campo de busca
//		WebElement valorBusca = driver.findElement(By.name("q"));
//		valorBusca.sendKeys(" "+valorTagBusca.getText());
//		
//		
//		System.out.println("Preencheu a busca" +i);
//		
//		// clica no botão Buscar
//		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
//		buttonBuscar.click();
//				
//		System.out.println("Buscou" +i);
//		
//		i++;
//		
//    }
//	
    driver.get
   	("https://noticias.uol.com.br/cotidiano/ultimas-noticias/2018/03/21/dos-14-aos-93-anos-mulheres-querem-manter-vivo-legado-de-marielle.htm");
    
	wait(50000);
	
     System.out.println(driver.getTitle());
       driver.quit();

  }

@Override
public WebDriver createDriver() {
	// TODO Auto-generated method stub
	return null;
}

}