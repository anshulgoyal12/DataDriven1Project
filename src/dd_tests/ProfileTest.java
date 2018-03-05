package dd_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.TestUtil;

public class ProfileTest extends TestCore{
	
	@BeforeTest
	public void skipException(){
		
		if(!TestUtil.isExecutable("ProfileTest")){
			
			throw new SkipException("Skipping the test case as runmode is set to No");
			
		}
		
		
		
	}
	
	@Test
	public void editProfile() throws InterruptedException{
		
		WebElement element = driver.findElement(By.xpath(object.getProperty("MyAccount")));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		app_logs.debug("Open the Profile");
		driver.findElement(By.xpath(object.getProperty("Profilelink"))).click();
		
		Thread.sleep(5000);
	
	}
	
}