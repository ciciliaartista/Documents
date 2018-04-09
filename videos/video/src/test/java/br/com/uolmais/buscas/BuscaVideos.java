package br.com.uolmais.buscas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaVideos extends TestBuscas {
	
	public void BuscaVideosMetodo() {
	
		while (i<=7) {
		
			//Entra no site do uolmais
			driver.get("http://mais.uol.com.br/");
			
			//Seleciona os vídeos mais recentes
			WebElement elem = driver.findElement(By.xpath("//*[@id=\"mais-recentes\"]/div/div/div/a/h2/strong"));
			//WebElement elem = driver.findElement(By.id("mais-recentes"));
			
			elem.click();
					
			//Seleciona o primeiro vídeo da fila
			
			//Chrome
			WebElement video1 = driver.findElement(By.xpath("//*[@id=\"zeitgeists\"]/li"+"["+i+"]"));
			
	//		//IE
	//		WebElement video1 = driver.findElement(By.cssSelector("#zeitgeists>li:nth-child(1)"));		
			
			video1.click();	
			
			wait(5000);
			System.out.println("Selecionou o primeiro da fila" +i);
			
			//Seleciona a primeira tag
			WebElement valorTagBusca = driver.findElement(By.className("tgw"));
			System.out.println("Tag "+valorTagBusca.getText());
			
			//Seleciona o mediaID
		
			List<WebElement> elements = driver.findElements(By.cssSelector(".uolplayer"));
			
	        for (WebElement el : elements) {
	
	               System.out.println("MediaId "+el.getAttribute("mediaid") + " ID: " + el.getAttribute("id"));
	
	        }
			
			wait(5000);
			System.out.println("Selecionou a primeira tag" +i);
			
			//Preenche o campo de busca
			WebElement valorBusca = driver.findElement(By.name("q"));
			valorBusca.sendKeys(" "+valorTagBusca.getText());
			
			wait(5000);
			System.out.println("Preencheu a busca" +i);
			
			// clica no botão Buscar
			WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
			buttonBuscar.click();
			
	//		wait(5000);
	//		System.out.println("Buscou" +i);
			
			i++;
		
		}
	
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
