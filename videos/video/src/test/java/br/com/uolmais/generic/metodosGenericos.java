package br.com.uolmais.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public abstract class metodosGenericos {
	
	public static WebDriver driver;
	public abstract WebDriver createDriver();
	private static final int TIMEOUT = 30;
	private static final List<Class<? extends Throwable>> IGNORE_EXCEPTION_LIST_DEFAULT = Arrays.asList(NoAlertPresentException.class, NoSuchElementException.class, UnhandledAlertException.class);


	
	protected static void clickWithMousePosition(WebElement elem) {
		
		System.out.println("Entrou no método do Mouse Position" );
		
		int width = elem.getSize().getWidth();

		Actions act = new Actions(driver);
		act.moveToElement(elem).moveByOffset((width / 2) - 2, 0).click().perform();
	}
	
	protected static void skipPublicidade() {
		
		System.out.println("Entrou no método de publicidade" );
//		WebElement ad = driver.findElement(By.cssSelector(".ad-container iframe"));
//		driver.switchTo().frame(ad);
//		driver.findElement(By.cssSelector(".videoAdUiSkipButton")).click();
//		driver.switchTo().defaultContent();
		
		WebElement ad = null;
		try {
			ad = waitForPresenceOf(driver, By.cssSelector(".ad-container iframe"));
		} catch(NoSuchElementException | TimeoutException ex) {
			System.out.println("Não possui AD");
		}
		
		if (ad != null) {
			try {
				driver.switchTo().frame(ad);
				
				WebElement skipAd = waitForClickOf(driver, By.cssSelector(".videoAdUiSkipButton"));
				skipAd.click();
			} catch(NoSuchElementException | TimeoutException ex) {
				System.out.println("Botão SKIP não apareceu");
			} finally {
				driver.switchTo().defaultContent();
			}
		}
		
		
	}
	
	protected static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static WebElement waitForClickOf(WebDriver driver, By locator) {
		return getDefaultFluentWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static Wait<WebDriver> getDefaultFluentWait(WebDriver driver) {
		return new FluentWait<WebDriver>(driver)
				        .withTimeout(TIMEOUT, TimeUnit.SECONDS)
						.ignoreAll(IGNORE_EXCEPTION_LIST_DEFAULT);
	}
	
	public static WebElement waitForPresenceOf(WebDriver driver, By locator) {
		return getDefaultFluentWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	


}
