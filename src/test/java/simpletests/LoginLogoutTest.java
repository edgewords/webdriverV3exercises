package simpletests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLogoutTest {
	
	WebDriver driver = new ChromeDriver();
	String baseURL = "https://www.edgewordstraining.co.uk/webdriver2";

	@Before
	public void setUp() throws Exception {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys("edgewords");
		driver.findElement(By.id("password")).sendKeys("edgewords123");
		driver.findElement(By.linkText("Submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		
		driver.findElement(By.linkText("Log Out")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
		
		String actualResult = driver.findElement(By.tagName("body")).getText();
		assertTrue(actualResult.contains("User is not Logged in"));
	}

}
