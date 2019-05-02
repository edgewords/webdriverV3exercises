package pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	WebDriver driver;
	
	public HomePagePOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText="Dismiss") WebElement dismissLink;
	@FindBy(id="woocommerce-product-search-field-0") WebElement searchBox;
	
	public void clickDismiss() {
		dismissLink.click();
	}
	
	public void searchFor(String item) {
		searchBox.clear();
		searchBox.sendKeys(item + Keys.ENTER);
	}
}
