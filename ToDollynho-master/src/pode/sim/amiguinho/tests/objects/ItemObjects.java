package pode.sim.amiguinho.tests.objects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ItemObjects {
	
	
	@iOSFindBy(id = "")
	@AndroidFindBy(id = "todo_desc_edit_text")
	public MobileElement DESCRICAO_MAROTA;
	
	@iOSFindBy(id = "")
	@AndroidFindBy(id = "todo_title_edit_text")
	public MobileElement TITULO_DO_TODO_MAROTO;
	
	
	@iOSFindBy(id = "")
	@AndroidFindBy(id = "todo_submit")
	public MobileElement SAVE_DOLLYNHO;
	
	

}
