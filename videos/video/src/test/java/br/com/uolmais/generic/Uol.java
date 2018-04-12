package br.com.uolmais.generic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Uol {
	
	private static final int TIMEOUT = 30;
	
	private static final List<Class<? extends Throwable>> IGNORE_EXCEPTION_LIST_DEFAULT = Arrays.asList(NoAlertPresentException.class, NoSuchElementException.class, UnhandledAlertException.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(TIMEOUT, TimeUnit.SECONDS);
		
		driver.get("http://mais.uol.com.br/view/65k9fo807g7i/trump-ameaca-russia-e-anuncia-novo-ataque-a-misseis-a-siria-kremlin-rebate-04024C9B336AC8A16326?types=A&");
		//driver.get("http://mais.uol.com.br/view/xawq16eu920g/meirelles-se-filia-ao-mdb-04024D193262C8A16326?types=A&");
		
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
		
		//driver.quit();
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
