package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {
	
	//variable declaration
	@FindBy (xpath="//h1[@class='card-title']")
    private WebElement TextAboutHDFCBank;
	
	@FindBy (xpath="(//span[@class='col-xs-1 col-sm-1 no-padding icon-right-open-big'])[5]")
    private WebElement CareersLink;
	
	@FindBy (xpath="(//span[@class='col-xs-1 col-sm-1 no-padding icon-right-open-big'])[1]")
    private WebElement OverviewLink;
	
	
	
	
//	variable initialization
	public AboutUsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
//variable use
	public String TextAboutHDFCBank() {
		String text=TextAboutHDFCBank.getText();
		return text;
	}
	public void clickOnCareersLink() {
		CareersLink.click();
	}
	public void clickOnOverviewLink() {
		OverviewLink.click();
	}

}
