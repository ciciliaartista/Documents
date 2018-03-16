package br.com.qualister.trianguloapp.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * Este teste apresenta, de forma simples, como utilizar o Appium em uma simples aplica��o
 * desde a inicializa��o do dispositivo at� o preenchimento de dados e compara��o de valores
 */
public class test {

	@Test
	public void testeTriangulo() throws MalformedURLException {
		
		// caminho da aplica��o que ser� testada
		File diretorioAplicacao = new File("C:/Users/vrt_coliveira/Documents/exemplo-appium-android-master/apps/triangulo");
		File arquivoAplicacao = new File(diretorioAplicacao, "TrianguloApp.apk");
		
		// capacidade (indicando plataforma, dispositivo e aplica��o)
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		// abre a conex�o com o servidor (url) e executa um dispositivo (descrito na capacidade)
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		
		// interagindo com os componentes
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado1")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado2")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtLado3")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btnCalcular")).click();
		
		// validando o resultado apresentado
		assertEquals("O traingulo equilatero", driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txtResultado")).getText());
		
	}

}
