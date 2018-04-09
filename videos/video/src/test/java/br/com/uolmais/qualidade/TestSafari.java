package br.com.uolmais.qualidade;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import br.com.uolmais.buscas.TestBuscas;

import java.net.URL;

public class TestSafari extends TestQualidade{

  public static final String USERNAME = "uolmais1"; 
  public static final String AUTOMATE_KEY = "E1cc19WKtji89sbxvVAG";
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  static int i = 1;

  public static void main(String[] args) throws Exception {
	  
	System.out.println("Setou o usuario "+USERNAME);  

    DesiredCapabilities caps = new DesiredCapabilities();
    
    caps.setCapability ("browserstack.local", "true");
    
    System.out.println("Denifiu as capacidades "+caps); 

    caps.setCapability("browser", "Safari");
    caps.setCapability("browser_version", "11.0");
    caps.setCapability("os", "OS X");
    caps.setCapability("os_version", "High Sierra");
    caps.setCapability("resolution", "1024x768");
    
    System.out.println("Denifiu o dispositivo "+caps.getBrowserName()); 
     
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
  
    // Busca
//    while (i<=5) {
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
    // Acesso vídeo normal
    
    driver.get
	("https://videos.bol.uol.com.br/video/conexao-animal-modelos-descobrem-curiosidades-sobre-aves-0402CD1C3564C4A16326");
    
 // Maximize a janela
    driver.manage().window().maximize();
    
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