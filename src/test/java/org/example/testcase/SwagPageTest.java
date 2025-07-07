package org.example.testcase;

import org.example.bases.BaseSetup;
import org.example.pages.LoginPage;
import org.example.pages.SwagPage;
import org.example.pages.DetaiProduct;
import org.example.pages.YourCartPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagPageTest extends BaseSetup {
    SwagPage swagPage;
    DetaiProduct detailPro;
    YourCartPage yourCartPage;
    @BeforeMethod
    public void loginWithValidCredentials_showSusscess() {
        LoginPage loginPage = new LoginPage(driver);
        swagPage = loginPage.loginFuntion("standard_user", "secret_sauce");
    }

    @Test (priority = 1)
    // TC01: Kiểm tra hiển thị menu
    public void verifyMenuItemDisplay() throws InterruptedException {

        swagPage.clickIconMenu();
        Thread.sleep(2000);
       // swagPage.closeAlert();
        Assert.assertTrue(swagPage.verifyMenuDisplay(), "Không hiển thị");

//        Assert.assertTrue(swagPage.verifyMenu_AllItems(), "All item không hiển thị");
//        Assert.assertTrue(swagPage.verifyMenu_AboutDisplay(), "About không hiển thị");
//        Assert.assertTrue(swagPage.verifyMenu_LogoutDisplay(), "Logout không hiển thị");

        }
    @Test (priority = 2)
    // Kiểm tra click vào All Items chuyển hướng đến trang swag và tắt popup menu
    public void clickAllItemsNavigate(){
        swagPage.clickIconMenu();
        swagPage.clickAllItems();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"), "URL không đúng");
       Assert.assertFalse(swagPage.verifyMenuDisplay(), "Vẫn hiển thị");
    }
    @Test
    // Kiểm tra click vào About chuyển hướng đến trang about
    public void clickAboutNavigate(){
        swagPage.clickIconMenu();
        swagPage.clickAbout();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://saucelabs.com/"));
    }
@Test
    // Kiểm tra click vào icon giỏ hàng và di chuyển đến đúng trang giỏ hàng
    public void clickCartNavigate(){
    swagPage.clickIconCart();
    Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/cart.html"));
    Assert.assertTrue(driver.findElement(By.xpath("//span[@class='title']")).getText().contains("Your Cart"));
}
@Test
    // Kiểm tra hiển thị đầy đủ thông tin của 1 sản phầm
    public void checkInfoProduct(){
        Assert.assertTrue(swagPage.isDisplayProduct(), "False");
}

@Test
    // Check điều hướng đến trang chi tiết sản phầm khi click vào title sản phẩm
    public void checkShowDetailProduct(){
    swagPage.clickTitleProduct(0);
    Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html?id="), "fale");
    DetaiProduct detailPro = new DetaiProduct(driver);
    String titlePro = detailPro.getTitleProduct();
    Assert.assertEquals(titlePro, "Sauce Labs Backpack", "fail");
    driver.navigate().back();
}

// Check điều hướng đến trang chi tiết sản phầm khi click vào hình ảnh sản phẩm
    @Test
    public void clickImgProNavigateDetailPro(){
        swagPage.clickImgProduct(0);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory-item.html?id="), "false");
        driver.navigate().back();
        // DetaiProduct detailPro = new DetaiProduct(driver);
    }
  // Thêm vào giỏ từ danh sách sản phẩm
  @Test
  public void addProductInList(){
      yourCartPage = new YourCartPage(driver);
      String title = swagPage.getTitleProduct(0);
      swagPage.clickBtnAddToCart(0);
      swagPage.clickIconCart();
      Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "false");
//      System.out.println("1: " + yourCartPage.getTitleProduct(0));
//      System.out.println("2 là : "  +title);
     Assert.assertTrue(yourCartPage.getTitleProduct(0).equals(title));
  }



  @Test
    public void verifySizetitlePro(){
      System.out.println(swagPage.getsoluongtitle());
      System.out.println(swagPage.getTitleProduct(1));
  }

}
