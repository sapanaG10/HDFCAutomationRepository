package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgriPage {
	
	//variable declaration
			@FindBy (xpath="//a[text()='Kisan Gold Card - Agri Loan']")
		    private WebElement KisanGoldCardButton;
			WebDriver driver;
			
	 //	variable initialization
			public AgriPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
			}
			
	//variable use
			public void KisanGoldCardButton() {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeAsyncScript("window.scrollBy(0,500)");
				
				KisanGoldCardButton.click();
			}
}