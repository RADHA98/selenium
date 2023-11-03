package modelaccessibletest.modelaccessibletest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WaiMethod {

	    private WebDriver driver;

			public WaiMethod(WebDriver driver) {
			// TODO Auto-generated constructor stub
				 this.driver = driver;
			}

			public void checkRolesandAttribute(WebElement modalElement, String expectedRole,
					String issueDescription, String attribute) {
				// TODO Auto-generated method stub
				 String actualRole = modalElement.getAttribute(attribute);
			        Assert.assertEquals(actualRole, expectedRole);
			
			}
//			public void checkModelIsClosed(WebElement addDeliveryCloseModal,void escapekey, String issueDescription)
//			{
////				Actions actions = new Actions(driver);
////				actions.sendKeys(escapekey).perform();
//				Assert.assertFalse(isDisplayed());
//			}

public void checkModelIsClosed(WebElement addDeliveryCloseModal, Keys escape, String string) {
	Actions actions = new Actions(driver);
	Assert.assertFalse(addDeliveryCloseModal.isDisplayed());
}
public void checkModelIsclosedCancel(WebElement addDeliveryCloseModal,String cancel,String String) {
	
	Assert.assertTrue(isFocusOnElement);
}
}


