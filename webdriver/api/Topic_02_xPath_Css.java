package api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_02_xPath_Css {
	WebDriver driver;
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000); 
	String randomUsername = "trungtest" + randomInt + "@gmail.com";
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email_Address() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("1234@123.123");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Login_03_Invalid_Password() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void Login_04_Incorrect_Email_Password() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).isDisplayed());
	}
	
	@Test
	public void Login_05_Create_A_New_Account() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys("trung");
		driver.findElement(By.id("lastname")).sendKeys("nguyen");
		driver.findElement(By.id("email_address")).sendKeys(randomUsername);
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("confirmation")).sendKeys("password123");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'trung')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'nguyen')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(string(),'gmail.com')]")).isDisplayed());
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();	
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();	
		
	}
	
	@Test
	public void Login_06_Login_With_Valid_Email_And_Password() {
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys(randomUsername);
		driver.findElement(By.id("pass")).sendKeys("password123");
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'Hello, trung nguyen!')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'trung')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'nguyen')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(string(),'gmail.com')]")).isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}