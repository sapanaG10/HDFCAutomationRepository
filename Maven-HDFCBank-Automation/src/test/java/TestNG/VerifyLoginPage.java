package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserSetup.Base;
import Page.AgriPage;
import Page.LoginPage;
import Page.LoginToNetBankingPage;

public class VerifyLoginPage extends Base {
	WebDriver driver;
	LoginPage loginPage;
	AgriPage agriPage;
	LoginToNetBankingPage loginToNetBankingPage;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)  {
		
		if(browserName.equals("Chrome"))
		{
			driver=openChromeBrowser();
			ChromeOptions ops=new ChromeOptions();
			ops.addArguments("---disable-notifications-");
		}
		
		if(browserName.equals("Edge"))
		{
			driver=openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void openBrowser() {

		loginPage=new LoginPage(driver);
	    agriPage=new AgriPage(driver);
	    loginToNetBankingPage=new LoginToNetBankingPage(driver);
	    
		
	}
	@BeforeMethod
	public void goToLoginPage() throws InterruptedException {
		System.out.println("before method");
	    driver.get("https://www.hdfcbank.com/");
	    Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void verifyApplyOnline(){
		loginPage=new LoginPage(driver);
		loginPage.clickOnSelectProductTypeTextBox();
		loginPage.clickOnSelectProductTextBox();
		loginPage.clickOnApplyOnline();
	}
	@Test(priority=2)
	public void verifyAgriPage() throws InterruptedException {
		Thread.sleep(5000);
		ArrayList<String> addr=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
		Thread.sleep(5000);
		loginPage=new LoginPage(driver);
		loginPage.clickOnAgriButton();
		Thread.sleep(8000);
		agriPage=new AgriPage(driver);
		agriPage.KisanGoldCardButton();
		}
	@Test(priority=2)
	public void verifyLoginToNetBankingPage() {
		loginPage=new LoginPage(driver);
		loginPage.clickOnLoginButton();
		loginPage.clickOnNetBankingButton();
		ArrayList<String> addr=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		loginToNetBankingPage=new LoginToNetBankingPage(driver);
		loginToNetBankingPage.switchToframe();
		loginToNetBankingPage.sendCustIdORUserId("123465667");
		loginToNetBankingPage.clickOnContinueButton();
		
	 }
	 @AfterMethod
		public void cleareObjects(){
			loginPage=null;
			agriPage=null;
			loginToNetBankingPage=null;
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
			driver=null;
			System.gc();
		}
}
