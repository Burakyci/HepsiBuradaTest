package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HbProductList extends BasePage {

	public WebDriver driver;

	By productList = By.cssSelector(".moria-ProductCard-eSkbaN");

	public HbProductList() throws IOException {
		super();
	}

	public List<WebElement> getHbProductList() throws IOException {
		this.driver = getDriver();
		return driver.findElements(productList);
	}

}
