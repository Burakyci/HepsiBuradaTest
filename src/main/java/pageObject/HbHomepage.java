package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HbHomepage extends BasePage {

	public WebDriver driver;

 	public By electronicSection = By.cssSelector(".sf-MenuItems-UHHCg2qrE5_YBqDV_7AC");
	By PcTabletLink = By.linkText("Bilgisayar/Tablet");            	
	public HbHomepage() throws IOException {
		super();
	}

	public WebElement getElectronicSection() throws IOException {
		this.driver = getDriver();
		return driver.findElement(electronicSection);
	}
	public WebElement getPcTabletLink() throws IOException {
		this.driver = getDriver();
		return driver.findElement(PcTabletLink);
	}
}
