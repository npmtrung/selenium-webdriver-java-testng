package api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Topic_03_Web_Driver {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Test
	public void TC_01_Run_On_Firefox() {
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		driver.quit();
	}
	
	@Test
	public void TC_02_Run_On_Chrome() {
		//Win 
		System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://live.demoguru99.com/");
		driver.quit();
		
		//Mac
	}


}