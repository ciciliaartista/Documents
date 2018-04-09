package br.com.uolmais.qualidade;

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
import br.com.uolmais.generic.metodosGenericos;
import br.com.uolmais.qualidade.ManterQualidade;
import br.com.uolmais.videosRelacionados.VideosRelacionados;


/**
 * Unit test for simple App.
 */
public abstract class TestQualidade extends metodosGenericos{

	public static WebDriver driver;
	public static Document doc = null;
	public static Image image = null;

	@Before
	public void setUp() throws IOException {
		
		driver = createDriver();
		
		// Maximize a janela
		driver.manage().window().maximize();
		
		wait(10000);
		
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

			//Verifica execução
			ManterQualidade verificaExecucao = new ManterQualidade();
			verificaExecucao.verificarSeVideoEstahExecutando();

			//Atualiza a qualidade
			ManterQualidade atualizarQualidade = new ManterQualidade();
			atualizarQualidade.mudarQualidadeVideo(qualidade);
			
			System.out.println("Mudou qualidade");
			
			
		});
	}
	
}
