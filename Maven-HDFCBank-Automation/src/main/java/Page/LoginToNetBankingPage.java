package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToNetBankingPage {
	
	//variable declaration
	//its s frame
	
	       @FindBy (xpath="//frame[@name='login_page']")
	       private WebElement frameNetBanking;
	
			@FindBy (xpath="//input[@type='text']")
		    private WebElement CustIdORUserId;
			
			@FindBy (xpath="//a[text()='CONTINUE']")
		    private WebElement continueButton;
			
			private WebDriver driver;
			
			//	variable initialization
			public LoginToNetBankingPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
				this.driver=driver;
			}
			
			//variable use
			public void switchToframe() {
		     driver.switchTo().frame(frameNetBanking);
		     
			}
			
			public void sendCustIdORUserId(String user) {
			CustIdORUserId.sendKeys(user);		
			}
			
			public void clickOnContinueButton() {
				continueButton.click();
			}
			

}
