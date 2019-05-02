package pom_tests;

import org.junit.Test;

import pom_pages.*;
import utilities.*;

public class ProductSearchPOMTest extends TestBase{


	@Test
	public void test() {
		HomePagePOM homepage = new HomePagePOM(driver);
		CapPagePOM cappage = new CapPagePOM(driver);
		
		homepage.searchFor("cap");
		cappage.clickaddToCartLink();
		cappage.clickviewCartLink();
	}

}
