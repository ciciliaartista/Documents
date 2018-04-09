package br.com.uolmais.qualidade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.main.Principal;
import br.com.uolmais.video.TestGeneric;

public class Test_evidencia extends TestGeneric {
	

	public static void main(String[] args) throws Throwable {
		
			Principal test = Principal.geraEvidencias();
	}

	@Override
	public WebDriver createDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
