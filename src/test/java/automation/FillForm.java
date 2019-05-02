package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.edgewordstraining.co.uk/webdriver2");
		driver.findElement(By.linkText("Access Basic Examples Area")).click();
		driver.findElement(By.linkText("Forms")).click();
		driver.findElement(By.id("textInput")).clear();
		driver.findElement(By.id("textInput")).sendKeys("Edgewords");
		driver.findElement(By.linkText("Submit")).click();
		//driver.quit();

	}

}
