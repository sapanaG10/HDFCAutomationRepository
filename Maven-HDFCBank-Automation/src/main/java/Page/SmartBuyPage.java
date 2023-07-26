package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBuyPage {
	
	//variable declaration
	
	        @FindBy (xpath="//a[text()='Privileges']")
            private WebElement PrivilegesButton;
	
			@FindBy (xpath="//span[text()='Infinia']")
		    private WebElement InfiniaDrop;
			
			WebDriver driver;
			
	 //	variable initialization
			public SmartBuyPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
			}
			
	//variable use
			public void privilegesButton() {
				Actions act=new Actions(driver);
				act.moveToElement(PrivilegesButton).build().perform();
			}
			public void clickOnInfiniaDrop() {
				Actions act=new Actions(driver);
				act.moveToElement(InfiniaDrop).click().build().perform();
			}
}


