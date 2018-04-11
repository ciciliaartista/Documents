package br.com.uolmais.video;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.main.Principal;
import br.com.uolmais.generic.TestGeneric;

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
