package utils;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;
    private static ConfigReader config = new ConfigReader();

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = config.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "/Users/apple/Downloads/chromedriver-mac-arm64/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}