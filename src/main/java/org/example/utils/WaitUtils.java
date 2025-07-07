package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
public void waitForClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
}
    public void waitForClickable(WebElement elme){
        wait.until(ExpectedConditions.elementToBeClickable(elme));
    }
}
