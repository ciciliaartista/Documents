package br.com.uolmais.videosRelacionados;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideosRelacionados extends TestVideosRelacionados{
	
	static int i = 2;
	static String VideosRelacionadosID;
		
	public void videosRelacionadosMetodo() {
		
		System.out.println("Entrou no método vídeos relacionados");
		
	while (i<=2) {
		
			//Seleciona o mediaID	
			List<WebElement> elements = driver.findElements(By.cssSelector(".uolplayer"));
		
			for (WebElement el : elements) {

				System.out.println("MediaId "+el.getAttribute("mediaid") + " ID: " + el.getAttribute("id"));
              
    			VideosRelacionadosID = el.getAttribute("id");
    			clickWithMousePosition(el);
    			wait(5000);
 			}
		
				wait(5000);

				System.out.println("Testando videos relacionados "+VideosRelacionadosID);
		
				WebElement elem = driver.findElement(By.className("up-bt-related"));
				elem.click();
		
				WebElement relacionadoFila = driver.findElement(By.cssSelector(".up-ul>li:nth-child("+i+")"));
				clickWithMousePosition(relacionadoFila);
			
				i++;
		
		}
		
	
	}


	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
