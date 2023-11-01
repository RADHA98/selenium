package modelaccessibletest.modelaccessibletest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Console;

public class testcasesmodel {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver-win64\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/dialog-modal/examples/dialog/");
	}

//   this testcase for checking role and click addressbtn

	@Test(priority = 1)
	public void testModalWithRole() {
		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();
		WebElement addDelivaryModal = waiPage.GetAddDelivaryModal();
//    	System.out.println(addDelivaryModal.getAttribute("id"));
		String actualRole = addDelivaryModal.getAttribute("role");
		String expectedRole = "dialog";
		Assert.assertEquals(actualRole, expectedRole, "Element's Role is incorrect we");
		WebElement cancelbtn = waiPage.GetCancelBtn();
		cancelbtn.click();
	}

	//aria-labelleby testcase
	@Test(priority = 2)
	public void checkModelWithAriaLabelledBy() {
		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();
		WebElement checkModelAriaLabelledBy = waiPage.GetAddDelivaryModal();
		String actualAriaLabelledBy = checkModelAriaLabelledBy.getAttribute("aria-labelledby");
		String expectedAriaLabelledBy = "dialog1_label";

		Assert.assertEquals(actualAriaLabelledBy, expectedAriaLabelledBy,
				"Element's aria-labelledby attribute is incorrect");
		WebElement cancelbtn = waiPage.GetCancelBtn();
		cancelbtn.click();
	}
// escapse key testcase
	@Test(priority = 3)
	public void closeModelWithEscapeKey() {
		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addDeliveryCloseModal = waiPage.GetAddDelivaryModal();

		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();

		Actions actions = new Actions(driver);
		actions.sendKeys(addDeliveryCloseModal, Keys.ESCAPE).perform();
		Assert.assertFalse(addDeliveryCloseModal.isDisplayed());

	}

	// focus is on first element
	@Test(priority = 4)
	public void testFirstElementFocus() {
		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();
		WebElement street = waiPage.EnterStreet();
		WebElement activeElement = driver.switchTo().activeElement();
		Assert.assertEquals(activeElement, street, "focus is not on the first element.");
		WebElement cancelbtn = waiPage.GetCancelBtn();
		cancelbtn.click();
	}

	// focus order chekcing first to last element.
	@Test(priority = 5)
	public void testFocusMaintenanceInModal() throws InterruptedException {

		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();
		WebElement modalId = waiPage.GetAddDelivaryModal();
		String Model = modalId.getAttribute("id");

		String interactiveElementXPath = "//*[@id='" + Model
				+ "']//*[self::a[@href] or self::area[@href] or self::input[not(@disabled)] or self::select[not(@disabled)] or self::textarea[not(@disabled)] or self::button[not(@disabled)] or @tabindex='0']";
		System.out.println(interactiveElementXPath);

		List<WebElement> allInteractiveElements = driver.findElements(By.xpath(interactiveElementXPath));

		System.out.println(allInteractiveElements.size());

		if (!allInteractiveElements.isEmpty()) {
			int elementCount = allInteractiveElements.size();
			WebElement firstInteractiveElement = allInteractiveElements.get(0);
			WebElement lastInteractiveElement = allInteractiveElements.get(elementCount - 1);

			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.moveToElement(firstInteractiveElement).sendKeys(Keys.TAB).perform();

			for (int i = 1; i < elementCount; i++) {
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(2000);
			}

			actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).perform();
		} else {
			System.out.println("No interactive elements found in the modal.");

		}
		WebElement cancelbtn = waiPage.GetCancelBtn();
		cancelbtn.click();
	}

	// when we close element focus is invoking element.
	@Test(priority = 6)
	public void testCloseModelfocus() throws InterruptedException {
		WAIpageopen waiPage = new WAIpageopen(driver);
		WebElement addressbtn = waiPage.GetAddressButton();
		addressbtn.click();

		WebElement cancelbtn = waiPage.GetCancelBtn();
		cancelbtn.click();
		WebElement elementToCheckFocus = waiPage.GetAddressButton();
		WebElement activeElement = driver.switchTo().activeElement();

		boolean isFocusOnElement = activeElement.equals(elementToCheckFocus);
		Assert.assertTrue(isFocusOnElement);
		Thread.sleep(3000);

	}

	@AfterTest
	private void closeChromeBroswer() {
		driver.quit();
	}
}
