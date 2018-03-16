package pode.sim.amiguinho.tests.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.After;
import org.junit.Before;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApBeforeAfter {
	
	protected AndroidDriver driver;
	DesiredCapabilities capacidade;
	
	@Before
    public void setUp() throws IOException {

        File appDir = new File( "/Users/ramses/Documents/Util");
        File app = new File(appDir, "gma-QA-RELEASE.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability("platformName", "Android");
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "0427579956");
		capacidade.setCapability("app", app.getAbsolutePath());
        
        try
        {
        	driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capacidade);
        	
        	
        } catch(MalformedURLException e)
        {
        	e.printStackTrace();
        }
		
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
