package api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Topic_03_Run_Browser_Part_I {
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
	}
		//Mac
		/*
		//Step 1
		System.setProperty("webdriver.chrome.driver",projectPath + "//browserDrivers//chromedriver");
		//Step 2: set permission for chromedriver
		driver = new ChromeDriver();
		driver.get("http://live.demoguru99.com/");
		driver.quit();
		*/
		
	@Test
	public void TC_03_Run_On_Edge() {
		System.setProperty("webdriver.edge.driver",projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://live.demoguru99.com/");
		driver.quit();		
	}


}