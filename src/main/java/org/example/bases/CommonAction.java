package org.example.bases;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// viết các method dùng chung đối với action
public class CommonAction {
    protected WebDriver driver;
    protected WaitUtils waitHelper;

    public CommonAction(WebDriver driver ) {
        this.driver = driver;
        this.waitHelper = new WaitUtils(driver);
    }

    public void actionSendKeys(By by, String value){
        waitHelper.waitForVisibility(by);
        driver.findElement(by).sendKeys(value);
    }
    public  void actionClick(By by){
        waitHelper.waitForClickable(by);
        driver.findElement(by).click();
    }
    public  void actionClick(WebElement elme){
        waitHelper.waitForClickable(elme);
        elme.click();
    }
    public void actionclearData(By by){
        waitHelper.waitForVisibility(by);
        driver.findElement(by).clear();
    }
    public String getErrorMess(By by){
        waitHelper.waitForVisibility(by);
        return driver.findElement(by).getText();
    }
    public String getText(By by){
        waitHelper.waitForVisibility(by);
        return driver.findElement(by).getText();
    }
    // By... : truyền nhiều by vào method (java vagas)
    public boolean isElementDisplay(By... items){
        for(By by: items) {
            waitHelper.waitForVisibility(by);
            if (driver.findElements(by).size() == 0 || !driver.findElement(by).isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isDisplayAlert(){
        try{
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

//    public boolean isElementDisplay(By by){
//        return driver.findElements(by).size() > 0 && driver.findElement(by).isDisplayed();
//    }
}
