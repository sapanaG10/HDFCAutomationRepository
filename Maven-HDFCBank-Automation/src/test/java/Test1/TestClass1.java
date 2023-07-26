package Test1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Page.LoginPage;

public class TestClass1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickOnSelectProductTypeTextBox();
		
		loginPage.clickOnSelectProductTextBox();
		loginPage.clickOnApplyOnline();
		
		loginPage.clickOnAboutUsLink();
	
	}

}
