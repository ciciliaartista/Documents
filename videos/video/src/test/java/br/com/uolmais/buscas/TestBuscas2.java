package br.com.uolmais.buscas;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import br.com.evidencias.CriaPDF;
import br.com.main.Principal;

/**
 * Unit test for simple App.
 */
public abstract class TestBuscas2 {

	public static WebDriver driver;
	public static File dir2;
	public static Document doc = null;
	public static Image image = null;
	String nomeBrownse;
	int i = 1;

	@Before
	public void setUp() throws IOException {
		
		driver = createDriver();
		
		CriaPDF.captureScreenShot(driver, doc, image);
		CriaPDF.gravaImagensPdf(doc, image);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CriaPDF.captureScreenShot(driver, null, null);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		CriaPDF.captureScreenShot(driver, null, null);
	}
	
	@After
	public void tearDown() throws Throwable {
		
		//System.out.println("Teste executado com o brownse "+driver);
				
		System.out.println("Gerando evidências");
		
		dir2 = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/Auto_Play/IE/Auto_Play");
		dir2.mkdir();
		
		Document doc = CriaPDF.CriaPDFs(dir2);
		
		CriaPDF.addCabecalhoPDF(doc, "");
		
		WebDriver driver = null;
		CriaPDF.insertSummary(driver, doc);
		
		String requirements = null;
		String target = null;
		String nomeTestCase = null;
		
		CriaPDF.insertDescription(doc, requirements, target, nomeTestCase);
		
		CriaPDF.gravaImagensPdf(doc, null);
		
		System.out.println("Teste executado "+i +"vezes");
		
		doc.close();
				
		System.exit(0);
	}
	
	public abstract WebDriver createDriver();

	@Test
	public void testStorage() {
		
	
		// Maximize a janela
		driver.manage().window().maximize();
		
		//Entra no site do uolmais
		driver.get("http://mais.uol.com.br/");
		
		//Seleciona os vídeos mais recentes
		WebElement elem = driver.findElement(By.xpath("//*[@id=\"mais-recentes\"]/div/div/div/a/h2/strong"));
		elem.click();
			
		//List<WebElement> videos = driver.findElements(By.cssSelector("#zeitgeists li"));
		
		WebElement video1 = driver.findElement(By.className("video"));
		System.out.println("Conseguiu executar o comando do primeiro " +video1);
		clickWithMousePosition(video1);
		 
		// percorre os vídeos, ou assim, ou fazendo um for normal

//		for (WebElement v : video1) {

			//Seleciona os vídeos mais recentes
			video1.click();
			
			//Seleciona a primeira tag
			WebElement valorTagBusca = driver.findElement(By.className("tgw"));
			System.out.println("Tag "+valorTagBusca.getText());
			
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
			
			wait(5000);
			System.out.println("Buscou" +i);
			
			
			try {
				CriaPDF.captureScreenShot(driver, doc, image);
				CriaPDF.gravaImagensPdf(doc, image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				CriaPDF.gravaImagensPdf(doc, image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;


		}
			
//			System.out.println("Teste executado "+i);
//	}


	private void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Usando eventos do mouse pelo selenium
	private void clickWithMousePosition(WebElement elem) {
		int width = elem.getSize().getWidth();

		Actions act = new Actions(driver);
		act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().perform();
	}


}
