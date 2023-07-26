package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPopUp {
	
	@FindBy (xpath="//button[@id='close-pc-btn-handler']")
    private WebElement ProceedPopup;
	
	public CookiesPopUp(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public void clickOnCookiesPopup() {
		ProceedPopup.click();
	}


}
