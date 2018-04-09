package br.com.uolmais.qualidade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.Document;

import br.com.evidencias.CriaPDF;
import br.com.main.Principal;

public class TestFirefox extends TestQualidade {

	@Override
	public WebDriver createDriver() {
			
		return new FirefoxDriver();
		
		
	}
	


}
