package utilities;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	protected WebDriver driver = new ChromeDriver();
	protected String baseURL = "https://www.edgewordstraining.co.uk/demo-site";
	
	@Before
	public void setUp() throws Exception {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Dismiss")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
