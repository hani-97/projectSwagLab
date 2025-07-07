package org.example.bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

// Set up driver trước mỗi test (@BeforeMethod)
//Quit driver sau test (@AfterMethod)
// được kế thừa bởi tất cả  Test
public class BaseSetup {
protected WebDriver driver;
@BeforeMethod
public void setupDriver(){
    driver = DriverFactory.choseBrowser("chrome");
    driver.get("https://www.saucedemo.com/");

}
@AfterMethod
public void teaDow() throws InterruptedException {
    if(driver != null){
        driver.quit();
    }
    Thread.sleep(2000);
}
}
