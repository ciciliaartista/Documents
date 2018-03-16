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
 * Este teste apresenta, de forma simples, como utilizar o Appium em uma simples aplicação
 * desde a inicialização do dispositivo até o preenchimento de dados e comparação de valores
 */
public class uolMaisMobileChrome {

	@Test
	public void testeTriangulo() throws MalformedURLException {
		
		// caminho da aplicação que será¡ testada
		File diretorioAplicacao = new File("C:/Users/vrt_coliveira/Documents/exemplo-appium-android-master/apps/triangulo");
		File arquivoAplicacao = new File(diretorioAplicacao, "TrianguloApp.apk");
		
		// capacidade (indicando plataforma, dispositivo e aplicação)
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capacidade.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		// abre a conexão com o servidor (url) e executa um dispositivo (descrito na capacidade)
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		
		//acessando a pagina do video
		
		driver.get("http://mais.uol.com.br/view/8bak1uywu0n2/avenida-norte-ganha-nova-circulacao-a-partir-deste-sabado-0402CC993168C0A16326?types=A&");
		
		// validando o resultado apresentado
		
		
	}

}
