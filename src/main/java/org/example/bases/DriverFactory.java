package org.example.bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

// khởi tạo object đối tượng WebDriver,
// tùy vào browser mà bạn muốn chạy test (chrome, firefox, safari, v.v.)
public class DriverFactory {
    public static WebDriver driver;

    public static WebDriver choseBrowser(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("incognito"); // chế độ ẩn danh
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-features=AutofillServerCommunication");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        return driver;
    }
}
