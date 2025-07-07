package org.example.testcase;

import org.example.bases.BaseSetup;
import org.example.dataProviders.DataProviders;
import org.example.pages.LoginPage;
import org.example.pages.SwagPage;
import org.example.pages.YourCartPage;
import org.example.pages.YourInformationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class YourInformationTest extends BaseSetup {
    SwagPage swagPage;
    YourCartPage yourCartPage;
    YourInformationPage yourInformationPage;

    @BeforeMethod
    public void ValidCheckoutFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFuntion("standard_user", "secret_sauce");
        swagPage = new SwagPage(driver);
        swagPage.clickBtnAddToCart(0);
        swagPage.clickIconCart();
        yourCartPage = new YourCartPage(driver);
        yourCartPage.clickBtnCheckoutCart();
    }

    @Test(dataProvider = "csvInformation1", dataProviderClass= DataProviders.class)
    public void verifyWithInformation(String fristname, String lastname, String code, String expectedMess) {
        YourInformationPage yourInformationPage = new YourInformationPage(driver);
        yourInformationPage.clickBtnContinue(fristname, lastname, code);
        if (!expectedMess.isEmpty()) {
            String actualMess = yourInformationPage.getTextErrorMess();
            Assert.assertEquals(actualMess, expectedMess);
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"));
            Assert.assertTrue(yourInformationPage.getTextHeader().contains("Overview"));
            yourInformationPage.clickBtnFinish();
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"));
            Assert.assertTrue(yourInformationPage.getTextHeader().contains("Complete"));
            Assert.assertTrue(yourInformationPage.getTextThanks().contains("Thank you for your order!"));
        }
    }

}
