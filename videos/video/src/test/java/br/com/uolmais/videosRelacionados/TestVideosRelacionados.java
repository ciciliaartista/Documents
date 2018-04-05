package br.com.uolmais.videosRelacionados;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import br.com.uolmais.videosRelacionados.VideosRelacionados;


/**
 * Unit test for simple App.
 */
public abstract class TestVideosRelacionados extends metodosGenericos{

	public static WebDriver driver;
	public static File dir2;
	public static Document doc = null;
	public static Image image = null;
	String nomeBrownse;
	static int i = 2;
	public static WebElement el;
	static String VideosRelacionadosID;

	@Before
	public void setUp() throws IOException {
		
		driver = createDriver();
		
		// Maximize a janela
		driver.manage().window().maximize();
		
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
		
		dir2 = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/Videos_Relacionados");
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
		
			//Entra no site do uolmais
		
			driver.get("http://mais.uol.com.br/view/91f2iyogwchf/honestidade-04029A3170E0910366?types=A&");
	
			while (i<=10) {
			
				//Seleciona o mediaID	
			
				List<WebElement> elements = driver.findElements(By.cssSelector(".uolplayer"));
			
				for (WebElement el : elements) {

					System.out.println("MediaId "+el.getAttribute("mediaid") + " ID: " + el.getAttribute("id"));
                  
        			VideosRelacionadosID = el.getAttribute("id");
        			clickWithMousePosition(el);
        			//wait(5000);
        			VideosRelacionados.videosRelacionadosMetodo();
 
				}
			
			wait(5000);
			
				
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
			
	}
	
//	private static void videosRelacionados() {
//
//		System.out.println("Testando videos relacionados "+VideosRelacionadosID);
//		
//		WebElement elem = driver.findElement(By.className("up-bt-related"));
//		elem.click();
//		
//		WebElement relacionadoFila = driver.findElement(By.cssSelector(".up-ul>li:nth-child("+i+")"));
//        clickWithMousePosition(relacionadoFila);
//				
//		wait(2000);
//		
//	}
//	
//	private static void wait(int time) {
//		try {
//			Thread.sleep(time);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Usando eventos do mouse pelo selenium
//	private static void clickWithMousePosition(WebElement elem) {
//		
//		System.out.println("Entrou no método do Mouse Position" );
//		
//		int width = elem.getSize().getWidth();
//
//		Actions act = new Actions(driver);
//		act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().perform();
//	}

}