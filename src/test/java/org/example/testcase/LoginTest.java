package org.example.testcase;

import org.example.bases.BaseSetup;
import org.example.dataProviders.DataProviders;
import org.example.pages.LoginPage;
import org.example.pages.SwagPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
// class này chịu trách nhiệm chạy và assert
public class LoginTest extends BaseSetup {
    LoginPage loginPage;
    SwagPage swagPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    // TC1: Đăng nhập với thông tin hợp lệ và k hợp lệ
    @Test(dataProvider = "csvLoginData", dataProviderClass = DataProviders.class)
    public void loginWithValidCredentials_showSusscess(String username, String pass, String expectedMess) {
        //  LoginPage loginPage = new LoginPage(driver);
        swagPage = loginPage.loginFuntion(username, pass);
        if(!expectedMess.isEmpty()){ // nếu có thông báo lỗi thì:
            String actualMess = loginPage.getErrorMess();
            Assert.assertEquals(actualMess, expectedMess);
        }else{
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        }

    }

//    // TC2: Đăng nhập với username và pass không hợp lệ
//    @Test(priority = 2)
//    public void loginWithInvalid_showErrorMess() {
//        //LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginFuntion("test", "secret_sauce");
//        String mess_equal = loginPage.getErrorMess();
//        String mess_expected = "Sai email/pass. Vui lòng nhập lại";
//        Assert.assertEquals(mess_equal, mess_expected, "Hiển thị sai mess");
//    }
//
//    // TC3: Để trống username
//    @Test
//    public void loginWithInvalidUser_showErrorMess() {
//        loginPage.loginFuntion("", "secret_sauce");
//        String mess_equal = loginPage.getErrorMess();
//        String mess_expected = "Epic sadface: Username is required";
//        Assert.assertEquals(mess_equal, mess_expected, "Hiển thị sai mess");
//    }
//
//    //TC4: Để trống pass
//    @Test
//    public void loginWithInvalidPass_showErrorMess() {
//        loginPage.loginFuntion("standard_user", "");
//        String messEquals = loginPage.getErrorMess();
//        String messExpected = "Epic sadface: Password is required";
//        Assert.assertEquals(messEquals, messExpected, "Hiển thị sai");
//    }

    //TC5: Click icon [x] để tắt thông báo lỗi
    @Test
    public void closeErrorMess() {
        loginPage.clickCloseErrorMessageIcon("", "");
    }

    @Test(priority = 3)
    public void iconClear() {
        loginPage.clearDataEmail("test");
    }



}
