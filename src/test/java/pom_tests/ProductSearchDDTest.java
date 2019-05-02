package pom_tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

import pom_pages.CapPagePOM;
import pom_pages.HomePagePOM;
import utilities.TestBase;

// Data Driven Test
@RunWith(Parameterized.class)
public class ProductSearchDDTest extends TestBase{
	String searchItem;

	// our constructor to set the data values
	public ProductSearchDDTest(String searchItem) {
		this.searchItem = searchItem;
	}
	
	// set up test data:
	@Parameters
	public static Collection<String[]> testData(){
		return Arrays.asList(new String[][] {
			{"Cap"},
			{"Beanie"},
			{"Belt"}
		});
	}

	@Test
	public void test() {
		HomePagePOM homepage = new HomePagePOM(driver);
		CapPagePOM cappage = new CapPagePOM(driver);
		
		homepage.searchFor(searchItem);
		cappage.clickaddToCartLink();
		cappage.clickviewCartLink();
		
		String actualResult = driver.findElement(By.tagName("body")).getText();
		assertTrue(actualResult.contains(searchItem));
	}

}
