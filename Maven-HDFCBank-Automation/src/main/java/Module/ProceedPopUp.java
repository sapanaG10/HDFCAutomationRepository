package Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProceedPopUp {
	

	@FindBy (xpath="//a[@id='redirectPopupUrl1']")
    private WebElement ProceedPopup;
	
	private WebDriver driver;
	
	public ProceedPopUp(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	
	public void clickOnProceedPopup() {
	Actions act=new Actions(driver);
	act.moveToElement(ProceedPopup).click().build().perform();
	}
}