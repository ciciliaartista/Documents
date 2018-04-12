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
import br.com.uolmais.generic.metodosGenericos;
import br.com.uolmais.videosRelacionados.VideosRelacionados;

/**
 * Unit test for simple App.
 */
public abstract class TestBuscasUsuario extends metodosGenericos {

	public static File dir2;
	public static Document doc = null;
	public static Image image = null;
	String nomeBrownse;
	static int i = 1;

	@Before
	public void setUp() throws IOException {
		
		driver = createDriver();
		
		// Maximize a janela
		driver.manage().window().maximize();
		
//		CriaPDF.captureScreenShot(driver, doc, image);
//		CriaPDF.gravaImagensPdf(doc, image);
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		CriaPDF.captureScreenShot(driver, null, null);
//		
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		
//		CriaPDF.captureScreenShot(driver, null, null);
	}
	
	@After
	public void tearDown() throws Throwable {
		
		//System.out.println("Teste executado com o brownse "+driver);
				
		System.out.println("Gerando evidências");
		
		dir2 = new File("C:/Users/vrt_coliveira/Desktop/Uol_Mais_QA/Changes/Evidencias/Buscas/Busca");
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
	
	@Test
	public void testBusca() {
		
			BuscaVideosUsuario busca = new BuscaVideosUsuario();
			busca.BuscaVideosUsuarioMetodo();
			wait(15000);
		
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
			
			System.out.println("Teste executado "+i);

		}
	

}