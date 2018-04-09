package br.com.uolmais.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class metodosGenericos {
	
	
	public static WebDriver driver;
	
	public abstract WebDriver createDriver();

	
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
