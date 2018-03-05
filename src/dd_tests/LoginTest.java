package dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class LoginTest extends TestCore{
	
	@BeforeTest
	public void skipException(){
		
		if(!TestUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the testcase as the run mode is set to No");
		}
	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username, String password) throws IOException{
		
		driver.findElement(By.xpath(object.getProperty("signInlink"))).click();
		driver.findElement(By.xpath(object.getProperty("signInasBuyerlink"))).click();
		app_logs.debug("Entering the username and password");
		driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(object.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(object.getProperty("SignInButton"))).click();
		TestUtil.captureScreenshot();
		
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return TestUtil.getData("LoginTest");
		
		
	}
}
