package core;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BaseFunctions {

    private static final String CHROME_DRIVER_LOCATION = "C:/chromedriver.exe";
    private static final Logger LOGGER = Logger.getLogger(BaseFunctions.class);
    public WebDriver driver;

    public BaseFunctions() {
        this.initDriver();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        LOGGER.info("goToUrl > User goes to: " + url);
        driver.get(url);
    }

    public void stopDriver() {
        /*
        webDriver.close() - Close the browser window that the driver has focus of
        webDriver.quit() - Calls Dispose()
        webDriver.dispose() Closes all browser windows and safely ends the session
         */
        LOGGER.info("stopDriver > Stopping driver");
        driver.quit();
    }

    public void switchingTabs() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void waitForElement(By element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, mills);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElement(By locator) {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated
                        (locator));
    }

    public boolean isPresentElement(By element) {
        List<WebElement> elements = driver.findElements(element);
        return !elements.isEmpty();
    }


    public WebElement findElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }
}