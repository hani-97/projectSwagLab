package org.example.pages;

import org.example.bases.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInformationPage extends CommonAction {
    private By btn_Continue = By.xpath("//input[@id='continue']");
    private By btn_Cancel = By.xpath("//button[@id='cancel']");
    private By field_first_name = By.xpath("//input[@id='first-name']");
    private By field_last_name = By.xpath("//input[@id='last-name']");
    private By field_code = By.xpath("//input[@id='postal-code']");
private By header = By.xpath("//div[@class='header_secondary_container']");
private By error_mess = By.xpath("//div[@class='error-message-container error']");
private By btn_finish = By.xpath("//button[@id='finish']");
private By text_Thanks = By.xpath("//h2[normalize-space()='Thank you for your order!']");
    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickBtnCancel(){
        actionClick(btn_Cancel);
    }
    public void clickBtnContinue(String firstName, String lastName, String code){
        actionSendKeys(field_first_name, firstName);
        actionSendKeys(field_last_name, lastName);
        actionSendKeys(field_code, code);
        actionClick(btn_Continue);
    }
    public void clickBtnFinish(){
        actionClick(btn_finish);
    }
public String getTextHeader(){
    return getText(header);
}
    public String getTextErrorMess(){
        return getText(error_mess);
    }
    public String getTextThanks(){
        return getText(text_Thanks);
    }

}
