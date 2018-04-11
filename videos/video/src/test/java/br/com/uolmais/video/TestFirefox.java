package br.com.uolmais.video;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.itextpdf.text.Document;

import br.com.evidencias.CriaPDF;
import br.com.main.Principal;
import br.com.uolmais.generic.TestGeneric;

public class TestFirefox extends TestPlayVideoUnico {

	@Override
	public WebDriver createDriver() {
			
		return new FirefoxDriver();
		
		
	}
	


}
