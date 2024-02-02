package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HbProductDetail extends BasePage {

	public WebDriver driver;

	By addCardBtn = By.cssSelector("button#addToCart");


	public HbProductDetail() throws IOException {
		super();
	}

	public WebElement getAddCardBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(addCardBtn);
	}

}
