package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DialogTest {
    private WebDriver driver;
    private ChromeOptions options;
    private DialogPage dialogPage;
    private AssertDialog assertDialog;

    @BeforeTest
    public void setUp() {
        // Set driver path dynamically or through system properties/environment variables
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        options = new ChromeOptions();
        
        options.addArguments("--remote-allow-origins=*");
       
        driver = new ChromeDriver(options);
        try {
            Thread.sleep(5000); // Add a delay to allow the browser to fully launch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        driver.get("https://www.w3.org/WAI/ARIA/apg/patterns/dialog-modal/examples/dialog/");
        dialogPage = new DialogPage(driver);
        assertDialog = new AssertDialog(driver);
    }


	@Test(priority = 1)
	public void testModalWithRole() {
		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		WebElement addDelivaryModal = dialogPage.getAddDelivaryModal();
		assertDialog.checkRolesandAttribute(addDelivaryModal, "dialog", "role is not match", "role");
		WebElement cancelbtn = dialogPage.getCancelBtn();
		cancelbtn.click();
	}

	@Test(priority = 2)
	public void checkModelWithAriaLabelledBy() {

		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		WebElement checkModelAriaLabelledBy = dialogPage.getAddDelivaryModal();
		assertDialog.checkRolesandAttribute(checkModelAriaLabelledBy, "dialog1_label",
				"Element's aria-labelledby attribute is incorrect", "aria-labelledby");
		WebElement cancelbtn = dialogPage.getCancelBtn();
		cancelbtn.click();
	}

	@Test(priority = 3)
	public void closeModelWithEscapeKey() {

		WebElement addDeliveryCloseModal = dialogPage.getAddDelivaryModal();

		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		assertDialog.checkModalIsClosedEsc(addDeliveryCloseModal, Keys.ESCAPE, "model is not displayed");

	}

	@Test(priority = 4)
	public void testFirstElementIsFocused() {

		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		WebElement street = dialogPage.enterStreet();
		WebElement activeElement = driver.switchTo().activeElement();
		assertDialog.checkFirstElementReceiveFocus(activeElement, street, "Focus is not on the first element.");

		WebElement cancelbtn = dialogPage.getCancelBtn();
		cancelbtn.click();
	}

	@Test(priority = 6)
	public void TestCloseCheckfocusIsInvolkingElement() throws InterruptedException {

		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		WebElement addDeliveryCloseModal = dialogPage.getAddDelivaryModal();

		WebElement cancelbtn = dialogPage.getCancelBtn();
		cancelbtn.click();

		assertDialog.checkFocusIsInvokingElement(addressbtn, null, "Model is not closed", driver);

	}

	@Test(priority = 5)
	public void testFocusMaintainInModal() throws InterruptedException {

		WebElement addressbtn = dialogPage.getAddressButton();
		addressbtn.click();
		WebElement modalId = dialogPage.getAddDelivaryModal();
		String Modal = modalId.getAttribute("id");

		String interactiveElementXPath = "//*[@id='" + Modal
				+ "']//*[self::a[@href] or self::area[@href] or self::input[not(@disabled)] or self::select[not(@disabled)] or self::textarea[not(@disabled)] or self::button[not(@disabled)] or @tabindex='0']";

		List<WebElement> allInteractiveElements = driver.findElements(By.xpath(interactiveElementXPath));

		if (!allInteractiveElements.isEmpty()) {
			int elementCount = allInteractiveElements.size();
			WebElement firstInteractiveElement = allInteractiveElements.get(0);
			WebElement lastInteractiveElement = allInteractiveElements.get(elementCount - 1);

			assertDialog.performFocusMaintain(firstInteractiveElement, lastInteractiveElement, Keys.TAB, Keys.SHIFT,
					elementCount,"No interactive elements found in the modal.");
		} 

		WebElement cancelbtn = dialogPage.getCancelBtn();
		cancelbtn.click();
	}
	


	@AfterTest
	private void closeChromeBroswer() {
		 if (driver != null) {
		driver.quit();
	}

}}
