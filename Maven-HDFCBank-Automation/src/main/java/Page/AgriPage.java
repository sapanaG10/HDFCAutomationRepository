package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgriPage {
	
	//variable declaration
			@FindBy (xpath="//a[text()='Kisan Gold Card - Agri Loan']")
		    private WebElement KisanGoldCardButton;
			
	 //	variable initialization
			public AgriPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
			
	//variable use
			public void KisanGoldCardButton() {
				KisanGoldCardButton.click();
			}
}