package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
public class DriverFactory {
private static WebDriver driver;

    public static WebDriver getChromeDriver() {
        String downloadFilepath = getDownloadPath();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriverManager.chromedriver().setup();

        ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(driverService, options);
       // return new ChromeDriver(driverService, options);
        return driver;
    }


    public static String getDownloadPath() {
        String directoryName = System.getProperty("user.dir") + File.separator + "download";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directoryName;
    }
}
