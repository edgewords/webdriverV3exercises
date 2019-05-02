package simpletests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchTest {

	WebDriver driver = new ChromeDriver();
	String baseURL = "https://www.edgewordstraining.co.uk/demo-site";

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

	@Test
	public void test() {
		driver.findElement(By.id("woocommerce-product-search-field-0")).click();
	    driver.findElement(By.id("woocommerce-product-search-field-0")).clear();
	    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("cap");
	    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(Keys.RETURN);
	    driver.findElement(By.name("add-to-cart")).click();
	    driver.findElement(By.linkText("Cart")).click();
		//check it is there
		assertTrue (driver.findElement(By.linkText("Cap")).isDisplayed());

	}

}
