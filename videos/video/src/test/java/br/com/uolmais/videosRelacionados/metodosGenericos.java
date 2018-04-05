package br.com.uolmais.videosRelacionados;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class metodosGenericos {
	
	public static WebDriver driver;

	
	
	protected static void clickWithMousePosition(WebElement elem) {
		
		System.out.println("Entrou no método do Mouse Position" );
		
		int width = elem.getSize().getWidth();

		Actions act = new Actions(driver);
		act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().perform();
	}
	
	protected static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
