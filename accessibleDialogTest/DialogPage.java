package modelaccessibletest.accessibleDialogTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DialogPage {

	WebDriver driver;

	public DialogPage(WebDriver d) {
		this.driver = d;
	}

	By addressbtn = By.xpath("//*[@id=\"ex1\"]/button");
	By AddDeliveryAddressmodal = By.xpath("//*[@id=\"dialog1\"]");

	By street = By.xpath("//*[@id=\"dialog1\"]/div[1]/div[1]/label/input");
	By city = By.xpath("//*[@id=\"dialog1\"]/div[1]/div[2]/label/input");
	By state = By.xpath("//*[@id=\"dialog1\"]/div[1]/div[3]/label/input");
	By pin = By.xpath("//*[@id=\"dialog1\"]/div[1]/div[4]/label/input");
	By specialinstructions = By.xpath("special_instructions");

	By add = By.xpath("//*[@id=\"dialog1\"]/div[2]/button[2]");
	By cancelbtn = By.xpath("//*[@id=\"dialog1\"]/div[2]/button[3]");

	
	public WebElement getAddressButton() {
		return driver.findElement(addressbtn);
		
	}

	public WebElement getAddDelivaryModal() {
		return driver.findElement(AddDeliveryAddressmodal);
	}

	public WebElement enterStreet() {
		return driver.findElement(street);
	}

	public WebElement enterCity() {
		return driver.findElement(city);
	}

	public WebElement enterState() {
		return driver.findElement(state);
	}

	public WebElement enterPin() {
		return driver.findElement(pin);
	}

	public WebElement enterSpecialInstructions() {
		return driver.findElement(specialinstructions);
	}

	public WebElement getCancelBtn() {
		return driver.findElement(cancelbtn);
	}

	
}

//		public void ClickOnaddbtn() {
//			driver.findElement(add);
//		}	
