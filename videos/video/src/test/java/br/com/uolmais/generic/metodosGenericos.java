package br.com.uolmais.generic;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public abstract class metodosGenericos {
	
	public static WebDriver driver;
	
	public abstract WebDriver createDriver();

	
	protected static void clickWithMousePosition(WebElement elem) {
		
		System.out.println("Entrou no método do Mouse Position" );
		
		int width = elem.getSize().getWidth();

		Actions act = new Actions(driver);
		act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().perform();
	}
	
	protected static void skipPublicidade() {
		
		System.out.println("Entrou no método de publicidade" );
		WebElement ad = driver.findElement(By.cssSelector(".ad-container iframe"));
		driver.switchTo().frame(ad);
		driver.findElement(By.cssSelector(".videoAdUiSkipButton")).click();
		driver.switchTo().defaultContent();
		
		
	}
	
	protected static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	


}
