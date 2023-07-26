package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
	
	//variable declaration
		@FindBy (xpath="//h2[text()='Join the winning team']")
	    private WebElement TextJoinTheWinningTeam;
		
		
//		variable initialization
		public CareersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
	//variable use
		
		public String clickOnTextJoinTheWinningTeam() {
			String text=TextJoinTheWinningTeam.getText();
			return text;
			
		}


}
