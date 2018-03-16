package pode.sim.amiguinho.tests.run;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import pode.sim.amiguinho.tests.pages.ItemPage;
import pode.sim.amiguinho.tests.pages.ToDoPage;

public class Birrll {
	
	protected AndroidDriver driver;
	DesiredCapabilities capacidade;
	
	ItemPage itemPage;
	ToDoPage toDoPage;
	
	
	@Before
    public void setUp() throws IOException {

        File appDir = new File( "<Coloca aqui o path do app amiguinhos>");
        File app = new File(appDir, "dollynhoapp-debug.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability("Platform_Name", MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

		capacidade.setCapability("app", app.getAbsolutePath());
        
        try
        {
        	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

        	
        	
        } catch(MalformedURLException e)
        {
        	e.printStackTrace();
        }
    
    }
	
	
	@Test
	public void vamoTestarBirrlll() throws InterruptedException {
		toDoPage = new ToDoPage(driver);
		itemPage = toDoPage.chooseButtonMaroto();
		Thread.sleep(3000);
		itemPage.selecinaAparadinhaTitulo();
		itemPage.informaAsParadinhasTitulo();
		itemPage.validaSapohhaTitulo();
		itemPage.selecionaAparadinhaDescricao();
		itemPage.informaAsParadinhasDescricao();
		itemPage.validaSapohhaTitulo();
		toDoPage = itemPage.salvaSapohhaToda();
	}
	
	
	
	
	   @After
	    public void tearDown() throws Exception 
	    {
	    	if(driver !=null)
	    	{
	    		driver.quit();
	    	}
	        
	    }

}
