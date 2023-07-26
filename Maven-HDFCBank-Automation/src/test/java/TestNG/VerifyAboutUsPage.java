package TestNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BrowserSetup.Base;
import Module.CookiesPopUp;
import Module.ProceedPopUp;
import Page.AboutUsPage;
import Page.AgriPage;
import Page.CareersPage;
import Page.LoginPage;
import Page.LoginToNetBankingPage;
import Page.SmartBuyPage;
import Utils.Utility;

public class VerifyAboutUsPage extends Base {
	WebDriver driver;
	LoginPage loginPage;
	SoftAssert soft;
	JavascriptExecutor js;
	SmartBuyPage smartBuyPage;
	CareersPage careersPage;
	String testId;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)  {
		System.out.println("Before Test");
		
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
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	}
	@BeforeClass
	public void createPOMObjects() {
		
		loginPage=new LoginPage(driver);
		smartBuyPage=new SmartBuyPage(driver);
	    careersPage=new CareersPage(driver);
	}
	@BeforeMethod
	public void goToLoginPage() throws InterruptedException {
		System.out.println("before method");
	    driver.get("https://www.hdfcbank.com/");
	    Thread.sleep(3000);
	}

	@Test(priority=3)
	public void verifySmartBuyPage() throws InterruptedException{
		Thread.sleep(7000);
		testId="T1";
		loginPage.clickOnOffersForYouLink();
		ArrayList<String> addr=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		String actualURL="https://offers.smartbuy.hdfcbank.com/v1/foryou";
		String expectedURL="https://offers.smartbuy.hdfcbank.com/v1/foryou";
		
		Assert.assertEquals(actualURL, expectedURL);
	//	ProceedPopUp proceedPopUp=new ProceedPopUp(driver);
	//	proceedPopUp.clickOnProceedPopup();
		smartBuyPage=new SmartBuyPage(driver);
		smartBuyPage.privilegesButton();
		smartBuyPage.clickOnInfiniaDrop();
	}
	
	@Test(priority=1)
	public void verifyAboutUsPage() throws InterruptedException {
		Thread.sleep(3000);
		testId="T2";
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1400)");
	
		loginPage.clickOnAboutUsLink();
		Thread.sleep(3000);
		AboutUsPage aboutUsPage=new AboutUsPage(driver);
		String actualText=aboutUsPage.TextAboutHDFCBank();
		String expectedText="	About HDFC Bank";
		
		soft=new SoftAssert();
		soft.assertNotEquals(actualText, expectedText);
		soft.assertAll();
		
		}
	
	@Test(priority=2)
	public void verifyCareerPage() throws InterruptedException {
		Thread.sleep(5000);
		testId="T3";
		loginPage=new LoginPage(driver);
		
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1400)");
		loginPage.clickOnAboutUsLink();
		AboutUsPage aboutUsPage=new AboutUsPage(driver);
	//	CookiesPopUp cookiesPopUp=new CookiesPopUp(driver);
	//	cookiesPopUp.clickOnCookiesPopup();
		
		Thread.sleep(2000);
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		
		aboutUsPage.clickOnCareersLink();
		Thread.sleep(4000);
	
		String actualText=careersPage.clickOnTextJoinTheWinningTeam();
	    String expectedText="Join the winning team\r\n"
	    		            + "\r\n"
	    		            + "";
	    
	    soft.assertNotEquals(actualText, expectedText);
	    soft.assertAll();
	}
	
	 @AfterMethod
	 public void logOut(ITestResult result) throws IOException{
			
			if(ITestResult.FAILURE==result.getStatus()) {
				Utility.captureScreenshot(driver, testId);
				
			}
			driver.close();
			
			
		}
		
		@AfterClass
		public void clearObjects() {
			loginPage=null;
			smartBuyPage=null ;
		}
		
		@AfterTest
		public void afterTest() {
			driver.quit();
			driver=null;
			System.gc();             // Garbage collector
		}
	
}



