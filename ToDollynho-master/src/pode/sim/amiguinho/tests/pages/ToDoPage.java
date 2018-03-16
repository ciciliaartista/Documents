package pode.sim.amiguinho.tests.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pode.sim.amiguinho.tests.objects.ToDoObjects;
import pode.sim.amiguinho.tests.util.AppiumCommons;

public class ToDoPage extends AppiumCommons {
	ToDoObjects toDoObjects = new ToDoObjects();
	
	public ToDoPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), toDoObjects);
	}
	
	public ItemPage chooseButtonMaroto() {
		toDoObjects.BOTAO_MAROTO.click();
		return new ItemPage(driver);
	}
}
