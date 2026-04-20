package SDET.Batch8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class titleValidation {
	
	WebDriver driver;
	String URL = "https://demo.guru99.com/V4/";
	String expTitle = "Guru99 Bank Home Page";
	

	@Test
	public void testCase_Titlevalidation() {
		String title = driver.getTitle();
		boolean result = expTitle.equals(title);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testCase_Buttomvalidation() {
		boolean result = true;
		
		
		try {
			WebElement login_WE = driver.findElement(By.name("btnLogin"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(login_WE));
		} catch (Exception e) {
			//handle exception
			result = false;
		}
		Assert.assertTrue(result);
		
	}


	@BeforeMethod
	public void initTest() {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.get(URL);
	}

	@AfterMethod
	public void cleanUpTest() {
		driver.quit();
	}


}
