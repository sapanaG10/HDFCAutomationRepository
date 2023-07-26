package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	//variable declaration
		@FindBy (xpath="(//button[text()='Login'])[1]")
	    private WebElement LoginButton;
		
		@FindBy (xpath="(//a[text()='NetBanking'])[1]")
	    private WebElement NetBankingDrop;
		
		@FindBy (xpath="(//a[@data-toggle='dropdown'])[1]")
	    private WebElement SelectProductTypeTextBox;
		
		@FindBy (xpath="(//a[@data-toggle='dropdown'])[2]")
	    private WebElement SelectProductTextBox;
		
		@FindBy (xpath="//a[text()='Apply online']")
	    private WebElement ApplyOnlineButton;
		
		@FindBy (xpath="//input[@id='search-chatInput']")
		private WebElement SearchButton;
		
		@FindBy (xpath="//div[text()='Credit cards']")
		private WebElement CreditCardButton;
		
		@FindBy (xpath="(//div[@class='sf-search-apply'])[2]")
		private WebElement MoneyBackApplyNowButton;
		
		@FindBy (xpath="(//li[@value='3'])[1]")
		private WebElement DepositsDrop;
		
		@FindBy (xpath="(//li[@value='1'])[2]")
		private WebElement FixedDepositDrop;
		
		@FindBy (xpath="(//a[@title='Agri'])[1]")
	    private WebElement AgriButton;
		
		@FindBy (xpath="//a[text()='Offers for You']")
	    private WebElement OffersForYouLink;
		
		@FindBy (xpath="//a[text()='About Us']")
		private WebElement AboutUsLink;
		
		WebDriver driver;
		
     //	variable initialization
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
	//variable use
		public void clickOnLoginButton() {
	    //	mouse action 
			Actions action=new Actions(driver);
			action.moveToElement(LoginButton).build().perform();
		}
		
		public void clickOnNetBankingButton() {
		 //	mouse action 
			Actions action=new Actions(driver);
			action.moveToElement(NetBankingDrop).click().build().perform();
		}
		
		
		public void clickOnSelectProductTypeTextBox() {
			SelectProductTypeTextBox.click();
			Actions act=new Actions(driver);
			act.moveToElement(DepositsDrop).click().build().perform();
		}
		public void clickOnSelectProductTextBox() {
			 SelectProductTextBox.click();
			 Actions act=new Actions(driver);
			 act.moveToElement(FixedDepositDrop).click().build().perform();
		}
		public void clickOnApplyOnline() {
			ApplyOnlineButton.click();
		}
        public void clickOnAgriButton() {
        	AgriButton.click();
        }
        public void clickOnOffersForYouLink() {
        	OffersForYouLink.click();
        }
        public void clickOnAboutUsLink() {
        	Actions act=new Actions(driver);
			act.moveToElement(AboutUsLink).click().build().perform();
        }
       
}
