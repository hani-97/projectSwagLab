package org.example.pages;

import org.example.bases.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonAction {
    WebDriver driver;

    private By txt_Email = By.id("user-name");
    private By txt_pass = By.id("password");
    private By btn_Login = By.id("login-button");
    private By icon = By.xpath("//div[@class='login-box']//div[1]//*[name()='svg']");
    private By txt_errmess = By.xpath("//h3[@data-test='error']");
    private By error_button = By.xpath("//button[@class='error-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SwagPage loginFuntion(String email, String pass) {
        actionSendKeys(txt_Email, email);
        actionSendKeys(txt_pass, pass);
        actionClick(btn_Login);
        return new SwagPage(driver);

    }

    public void clearDataEmail(String email) {
        actionSendKeys(txt_Email, email);
        actionClick(btn_Login);
        actionclearData(icon);
    }

    public String getErrorMess() {
        return getErrorMess(txt_errmess);
    }

    public void clickCloseErrorMessageIcon(String email, String pass) {
        loginFuntion(email, pass);
        actionClick(error_button);
    }

}
