package br.com.uolmais.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import br.com.evidencias.CriaPDF;
import br.com.main.Principal;

/**
 * Unit test for simple App.
 */
public abstract class TestGeneric {

	public static WebDriver driver;
	public static Document doc = null;
	public static Image image = null;

	@Before
	public void setUp() throws IOException {
		
		driver = createDriver();
		
		// Maximize a janela
//		driver.manage().window().maximize();
//		
//		wait(10000);
		
		CriaPDF.captureScreenShot(driver, doc, image);
		CriaPDF.gravaImagensPdf(doc, image);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		CriaPDF.captureScreenShot(driver, null, null);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		CriaPDF.captureScreenShot(driver, null, null);
	}
	
	@After
	public void tearDown() throws Throwable {
		
		System.out.println("Teste executado com o brownse "+driver);
				
		System.out.println("Gerando evidências");
		
		File dir2 = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/Autoplay");
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
		
		doc.close();
				
		System.exit(0);
	}
	
	public abstract WebDriver createDriver();

	@Test
	public void testStorage() {
		
		Arrays.asList("720p", "540p", "360p", "270p").forEach(qualidade -> {
			
			driver.get
			("http://mais.uol.com.br/view/78oudicj60ka/brasil-vence-o-canada-e-conquista-a-copa-caixa-04029B3370E0910366?types=A&"); 

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

			verificarSeVideoEstahExecutando();

			mudarQualidadeVideo(qualidade);
			
			System.out.println("Mudou qualidade");
			
			
		});
	}
	
	private void videosRelacionados() {
		
		//Seleciona os vídeos mais recentes
		WebElement elem = driver.findElement(By.xpath("//*[@id=\"UOLPlayer_15216653201762519\"]/div/div/div[3]/div[1]/div[1]"));
		System.out.println("Videos relacionados");
		elem.click();
		
	}

	private void mudarQualidadeVideo(String qualidade) {
		
		System.out.println("Testando qualidade "+qualidade);
		
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

	private void verificarQualidadeVideo(String qualidade) {
		WebElement elem = driver.findElement(By.cssSelector(".quality-type"));
		Assert.assertEquals(qualidade, elem.getAttribute("innerText"));
	}

	public static void wait(int time) {
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
	
	// Tentando usar o evento do mouse hover pelo Sistema Operacional
	private void __clickWithMousePosition(WebElement elem) {
		Point point = elem.getLocation();
		Dimension dimension = elem.getSize();

		try {
			Robot robot = new Robot();
			robot.mouseMove(point.getX() + (dimension.getWidth() / 2), point.getY() + (dimension.getHeight() / 2));
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	private void verificarSeVideoEstahExecutando() {
		List<WebElement> videosPlaying = driver.findElements(By.cssSelector(".uolplayer._playing .video-element"));
		Assert.assertEquals("Validando se player está tocando", 1, videosPlaying.size());
	}

}
