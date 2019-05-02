package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLogout {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.edgewordstraining.co.uk/webdriver2");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys("edgewords");
		driver.findElement(By.id("password")).sendKeys("edgewords123");
		driver.findElement(By.linkText("Submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		
		driver.findElement(By.linkText("Log Out")).click();
	}

}
