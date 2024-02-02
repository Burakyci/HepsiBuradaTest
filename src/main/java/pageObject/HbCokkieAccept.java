package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HbCokkieAccept extends BasePage {

	public WebDriver driver;

 	public By acceptCookie = By.cssSelector("#onetrust-accept-btn-handler");
	public HbCokkieAccept() throws IOException {
		super();
	}


	public WebElement getAcceptCookie() throws IOException {
		this.driver = getDriver();
		return driver.findElement(acceptCookie);
	}
}
