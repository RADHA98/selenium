package modelaccessibletest.modelaccessibletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WAIpageopen {



			WebDriver driver;
			
		 public  WAIpageopen (WebDriver d){
			driver=d;
		}


		    By addressbtn=  By.xpath("//*[@id=\"ex1\"]/button");
		    By AddDeliveryAddressmodel= By.xpath("//*[@id=\"dialog1\"]");
		    
		    By street=  By.xpath("//*[@id=\"dialog1\"]/div[1]/div[1]/label/input");
		    By city= By.xpath("//*[@id=\"dialog1\"]/div[1]/div[2]/label/input");
		    By state= By.xpath("//*[@id=\"dialog1\"]/div[1]/div[3]/label/input");
		    By pin= By.xpath("//*[@id=\"dialog1\"]/div[1]/div[4]/label/input");
		    By specialinstructions= By.xpath("special_instructions");
		   
		    By add= By.xpath("//*[@id=\"dialog1\"]/div[2]/button[2]");
		    By cancelbtn= By.xpath("//*[@id=\"dialog1\"]/div[2]/button[3]");
		    
		    
	public WebElement GetAddressButton() {
		return driver.findElement(addressbtn);
	}
	
	public WebElement GetAddDelivaryModal() {
		return driver.findElement(AddDeliveryAddressmodel);
	}
	
		public WebElement EnterStreet() {
		 return driver.findElement(street);
		}
		public WebElement EnterCity() {
			 return driver.findElement(city);
			}
		
		public WebElement EnterState() {
			 return driver.findElement(state);
			}
		
		public WebElement EnterPin() {
			return driver.findElement(pin);
			}
		public WebElement EnterSpecialInstructions() {
			return driver.findElement(specialinstructions);
		}
		
		public WebElement GetCancelBtn() {
			return driver.findElement(cancelbtn);
		}}
		
		
//		public void ClickOnaddbtn() {
//			driver.findElement(add);
//		}	
	
    