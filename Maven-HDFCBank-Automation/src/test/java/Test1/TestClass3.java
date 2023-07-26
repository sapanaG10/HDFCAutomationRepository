package Test1;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Page.LoginPage;
import Page.LoginToNetBankingPage;

public class TestClass3 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hdfcbank.com/");
		
		LoginPage loginPage=new LoginPage(driver);
	  
		loginPage.clickOnLoginButton();
		loginPage.clickOnNetBankingButton();
		
		ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		Thread.sleep(2000);
		LoginToNetBankingPage loginToNetBankingPage=new LoginToNetBankingPage(driver);
		Thread.sleep(8000);
		
		loginToNetBankingPage.switchToframe();
		loginToNetBankingPage.sendCustIdORUserId("122353555");
		loginToNetBankingPage.clickOnContinueButton();
		
	}
}
