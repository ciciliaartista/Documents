package pode.sim.amiguinho.tests.objects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ToDoObjects {
	
	@iOSFindBy(id = "")
	@AndroidFindBy(className = "android.widget.TextView")
	public MobileElement TITULO_MAROTO;
	
	@iOSFindBy(id = "")
	@AndroidFindBy(className = "android.widget.ImageButton")
	public MobileElement BOTAO_MAROTO;
	
	@iOSFindBy(id = "")
	@AndroidFindBy(id = "id/todo_title")
	public MobileElement TITULO_TODO_SALVO;

}
