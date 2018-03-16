package pode.sim.amiguinho.tests.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AppiumCommons {
	
	public AppiumDriver<MobileElement> driver;


	public AppiumCommons(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	

}
