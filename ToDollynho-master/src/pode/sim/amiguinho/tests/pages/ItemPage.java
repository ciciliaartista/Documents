package pode.sim.amiguinho.tests.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pode.sim.amiguinho.tests.objects.ItemObjects;
import pode.sim.amiguinho.tests.util.AppiumCommons;

import static org.junit.Assert.assertEquals;

public class ItemPage extends AppiumCommons {
	
	ItemObjects itemObjects = new ItemObjects();
	
	public ItemPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), itemObjects);
	}
	
	
	public ItemPage informaAsParadinhasDescricao() {
		
		itemObjects.DESCRICAO_MAROTA.click();
		itemObjects.DESCRICAO_MAROTA.sendKeys("Dolly");
		return new ItemPage(driver);
	}
	
	public ItemPage selecinaAparadinhaTitulo() {
		
		itemObjects.TITULO_DO_TODO_MAROTO.click();
		return new ItemPage(driver);
	}
	
	public ItemPage informaAsParadinhasTitulo() {
		
		itemObjects.TITULO_DO_TODO_MAROTO.sendKeys("Yeap");
		return new ItemPage(driver);
	}
	
	public ToDoPage validaSapohhaTitulo() {
		assertEquals("Yeap", itemObjects.TITULO_DO_TODO_MAROTO.getText()); //Sacaram a trollada aqui?
		
		return new ToDoPage(driver);
	}
	
	public ItemPage selecionaAparadinhaDescricao() {
		
		itemObjects.DESCRICAO_MAROTA.click();
		return new ItemPage(driver);
	}
	
	public ToDoPage validaSapohhaDescricao() {
		assertEquals("Dolly", itemObjects.DESCRICAO_MAROTA.getText());
		
		return new ToDoPage(driver);
	}
	
	public ToDoPage salvaSapohhaToda() {
		
		itemObjects.SAVE_DOLLYNHO.click();
		return new ToDoPage(driver);
	}

}
