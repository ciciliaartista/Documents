package br.com.qualister.trianguloapp.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBuscaDevices {
	
	static int i;
	static WebDriver driver;
	
	public static void testBusca() {
		
		while (i<=5) {
		
		//Entra no site do uolmais
		driver.get("http://mais.uol.com.br/");
		
		//Seleciona os vídeos mais recentes
		WebElement elem = driver.findElement(By.xpath("//*[@id=\"mais-recentes\"]/div/div/div/a/h2/strong"));
		elem.click();
				
		//Seleciona o primeiro vídeo da fila
		
		//Chrome
		//WebElement video1 = driver.findElement(By.xpath("//*[@id=\"zeitgeists\"]/li"+"["+i+"]"));
		
		//IE
		WebElement video1 = driver.findElement(By.cssSelector("#zeitgeists>li:nth-child(1)"));		
		
		video1.click();	
		
		System.out.println("Selecionou o primeiro da fila" +i);
		
		//Seleciona a primeira tag
		WebElement valorTagBusca = driver.findElement(By.className("tgw"));
		System.out.println("Tag "+valorTagBusca.getText());
		
		System.out.println("Selecionou a primeira tag" +i);
		
		//Preenche o campo de busca
		WebElement valorBusca = driver.findElement(By.name("q"));
		valorBusca.sendKeys(" "+valorTagBusca.getText());
		
		System.out.println("Preencheu a busca" +i);
		
		// clica no botão Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();
		
		System.out.println("Buscou" +i);
	

		}
		
		i++;
		
		System.out.println("Teste executado "+i);
		
	}
}



