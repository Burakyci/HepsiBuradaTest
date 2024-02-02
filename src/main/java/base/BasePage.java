package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private  String url;
    private final Properties prop;



    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/resource/config.properties");

        prop.load(data);
    }

    public static WebDriver getDriver() throws IOException {
       return WebDriverInstance.getDriver();
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }

    public void takeSnapShot(String name) throws IOException {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "/target/screenshots"
                + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }


    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static void waitForElementInVisible (WebElement element, Duration timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timer);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementVisible(WebElement element, Duration timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    Actions actions = new Actions(getDriver());

}
