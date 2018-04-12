package br.com.uolmais.qualidade;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManterQualidade extends TestQualidade{
	
	static String qualidadeId;
	
	public void mudarQualidadeVideo(String qualidade) {
		
		System.out.println("Testando qualidade "+qualidade);
		
		//Seleciona o mediaID	
		List<WebElement> elements = driver.findElements(By.cssSelector(".uolplayer"));
	
		for (WebElement el : elements) {

			System.out.println("MediaId "+el.getAttribute("mediaid") + " ID: " + el.getAttribute("id"));
          
			qualidadeId = el.getAttribute("id");
			clickWithMousePosition(el);
			wait(5000);
			}
		
		wait(5000);
		
		WebElement elem = driver.findElement(By.className("up-bt-tools"));
		clickWithMousePosition(elem);
		
		wait(2000);
		
		elem = driver.findElement(By.cssSelector(".up-ctrlbar-tools-label"));
		clickWithMousePosition(elem);
		
		wait(2000);
		
		elem = driver.findElement(By.cssSelector(".quality-"+qualidade));
		clickWithMousePosition(elem);
		
		wait(10000);
		
		verificarSeVideoEstahExecutando();
		verificarQualidadeVideo(qualidade);
	}

	public void verificarQualidadeVideo(String qualidade) {
		WebElement elem = driver.findElement(By.cssSelector(".quality-type"));
		Assert.assertEquals(qualidade, elem.getAttribute("innerText"));
	}


	public void verificarSeVideoEstahExecutando() {
		List<WebElement> videosPlaying = driver.findElements(By.cssSelector(".uolplayer._playing .video-element"));
		Assert.assertEquals("Validando se player está tocando", 1, videosPlaying.size());
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return null;
	}



}
