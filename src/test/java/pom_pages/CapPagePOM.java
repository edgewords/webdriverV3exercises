package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CapPagePOM {
WebDriver driver;
	
	public CapPagePOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="add-to-cart") WebElement addToCartLink;
	@FindBy(linkText="View cart") WebElement viewCartLink;
	
	public void clickaddToCartLink() {
		addToCartLink.click();
	}
	public void clickviewCartLink() {
		viewCartLink.click();
	}

}
