package simpletests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

//import our helper libraries:
import static utilities.UtilityLibrary.*;

public class ProductSearchHelpersTest extends TestBase {


	@Test
	public void test() {
		driver.findElement(By.id("woocommerce-product-search-field-0")).click();
	    driver.findElement(By.id("woocommerce-product-search-field-0")).clear();
	    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("cap");
	    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(Keys.RETURN);
	    //call our helper method:
	    WaitForElementToBeClickable(driver, By.name("add-to-cart"));
	    
	    driver.findElement(By.name("add-to-cart")).click();
	    driver.findElement(By.linkText("Cart")).click();
		//check it is there
		assertTrue (driver.findElement(By.linkText("Cap")).isDisplayed());

	}

}
