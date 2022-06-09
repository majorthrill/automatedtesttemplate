package expleo.mappings;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
public enum PageObject{
	    BLUEBUTTON      ("Blue Button", By.cssSelector(".button"), "button"),
	    REDBUTTON     	("Red Button", By.cssSelector(".button.alert"), "button alert"),
	    GREENBUTTON     ("Green Button", By.cssSelector(".button.success"), "button success"),
//	    GREENBUTTONBEFORE("Green Button Before", By.cssSelector(".button.success.before"), null),
	    TABLE			("Table", By.cssSelector(".large-10.columns"), null),
	    CANVAS			("Canvas", By.id("canvas"), null)		
	    ;
	
		private String name;
	    private By objectlocater;
	    private String className;
	    
	    private PageObject(String name, By objectlocater, String className) {
	        this.name = name;
	        this.objectlocater = objectlocater;
	        this.className = className;
	    }

	    public String getName() {
	        return name;
	    }

	    public By getObjectlocater() {
	        return objectlocater;
	    }

	    public String getClassName() {
	        return className;
	    }
	    public static PageObject findObjectByName(String name) {
	        for (PageObject po : PageObject.values()) {
	            if (po.getName().equalsIgnoreCase(name)) {
	                return po;
	            }
	        }
	        throw new IllegalStateException(name + " is not a valid page object");
	    }
}
