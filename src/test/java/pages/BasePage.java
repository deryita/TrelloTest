package pages;

import org.openqa.selenium.*;
import utilities.ConfigFileReader;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BasePage {


    private ConfigFileReader configFileReader;
    private static WebDriver driver;

    private static FluentWait<WebDriver> wait;


    public WebDriver getdriver() {
        if (driver == null) {
            this.driver = DriverFactory.getChromeDriver();
            configFileReader = new ConfigFileReader();
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30L))
                    .pollingEvery(Duration.ofSeconds(5L))
                    .ignoring(NoSuchElementException.class);

        }
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }

    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }

    public void goToURL(String url, By by) {
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                driver.navigate().to(url);
                WebElement element = arg0.findElement(by);
                if (element != null) {
                    System.out.println("Page Redirection Success");
                }
                return element;
            }
        };

        wait.until(function);

    }

    public void enterText(String text, By by) {
        findElement(by).sendKeys(text);
    }

    public void click(By by) {
        findElement(by).click();
    }


    private WebElement findElement(By by) {
        return wait.until(driver -> driver.findElement(by));
    }

    private List<WebElement> findElements(By by) {
        return wait.until(driver -> driver.findElements(by));
    }


    public boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public int isElementExists(By by) {
        return findElements(by).size();
    }
}
