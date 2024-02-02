package uk.co.automationtesting;
import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.HbHomepage;
import pageObject.HbProductDetail;
import pageObject.HbProductList;


import java.io.IOException;
import java.time.Duration;
import java.util.Set;

@Listeners(resource.Listeners.class)
public class AddProductCard extends Hooks {
    public AddProductCard() throws IOException{
        super();
    }


    @Test
    public void endToEndTest() throws InterruptedException, IOException {
        HbProductDetail hbProductDetail = new HbProductDetail();

        HbHomepage hbHomePage = new HbHomepage();

        WebElement element = getDriver().findElement(hbHomePage.electronicSection);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        hbHomePage.getElectronicSection();
        Thread.sleep(2222);
        hbHomePage.getPcTabletLink().click();
        Thread.sleep(11111);
        HbProductList hbProductList = new HbProductList();
        if(hbProductList.getHbProductList().isEmpty()){
            System.out.println("No products available");
            throw new RuntimeException("No products available");
        }else {
            waitForElementVisible( hbProductList.getHbProductList().get(0),Duration.ofSeconds(123232));

            hbProductList.getHbProductList().get(0).click();

            Thread.sleep(1111);

            String mainHandle = getDriver().getWindowHandle();
            Set<String> allHandles = getDriver().getWindowHandles();
            String newHandle = "";
            for (String handle : allHandles) {
                if (!handle.equals(mainHandle)) {
                    newHandle = handle;
                    break;
                }
            }
            getDriver().switchTo().window(newHandle);

            String pageTitle = getDriver().getTitle();

            System.out.println("Page Title: " + pageTitle);

            waitForElementVisible(hbProductDetail.getAddCardBtn(),Duration.ofSeconds(11111));
            hbProductDetail.getAddCardBtn().click();
            Thread.sleep(10222);

        };
        Thread.sleep(10222);




//        waitForElementInVisible(shoppingCart.getDeleteItemTwo(), Duration.ofSeconds(10));
//
//        System.out.println(shoppingCart.getTotalAmount().getText());
//        Assert.assertEquals(shoppingCart.getTotalAmount().getText(),"$45.23");

    }
}
