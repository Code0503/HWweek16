package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class MyAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    public MyAccountPage() {PageFactory.initElements(driver, this);}

    @CacheLookup
            @FindBy(xpath ="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]" )
WebElement MyAccount;
    @CacheLookup
            @FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']/li/a" )
List<WebElement> accountOption;
    @CacheLookup
            @FindBy(xpath ="//div[@id='content']/h1" )
WebElement VerifyRegisterText;

    @CacheLookup
            @FindBy(xpath = "//div[@id='content']/div/div[2]//h2" )
WebElement VerifyLoginText;
    @CacheLookup
            @FindBy(id ="input-email" )
WebElement Email;
    @CacheLookup
            @FindBy(name ="password" )
WebElement PassWord;
    @CacheLookup
            @FindBy(name = "confirm")
WebElement ConfirmPassword;
    @CacheLookup
            @FindBy(xpath = "//div[@class='form-group']/div/label/input")
WebElement subscribeRadioButton;
    @CacheLookup
            @FindBy(xpath ="//div[@class='pull-right']/input" )
WebElement privacyPolicy;
    @CacheLookup
            @FindBy(xpath = "//div[@class='pull-right']/input[2]")
WebElement continueButton;
    @CacheLookup
            @FindBy(xpath ="//div[@class='pull-right']" )
WebElement againContinueButton;
    @CacheLookup
            @FindBy(xpath = "//input[@value='Login']")
WebElement loginButton;
    @CacheLookup
            @FindBy(xpath = "//div[@id='account-account']/div/div/h2")
WebElement verifyLoginMessage;

    /*This method should click on the options whatever name is passed as parameter.
    (Hint: Handle List of Element and Select options)*/
public void clickOnMyAccountAndSelectOption(String AccountOption) {
    log.info("click on  my account tab :" +MyAccount.toString());
    clickOnElement(MyAccount);

    log.info("select an option form my account tab :" +accountOption.toString());
    List<WebElement> listOfNames = accountOption;
    try {
        for (WebElement element : listOfNames) {
            if (element.getText().equalsIgnoreCase(AccountOption)) {
                element.click();
            }
        }
    } catch (StaleElementReferenceException e) {//div[@id='account-register']//form/child::*
        listOfNames = accountOption;
    }
}
public String verifyUserOnRegisterAccountPage(){
    log.info("verify message :" +VerifyRegisterText.toString());
    return  getTextFromElement(VerifyRegisterText);
}
    public String verifyUserOnLoginPage(){
        log.info("verify message :" +VerifyLoginText.toString());
    return getTextFromElement(VerifyLoginText);
    }
    public void enterAnEmail(String emailName){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(500);
    sendTextToElement(Email,emailName+randomInt+"gmail.com");
    }
    public void enterPassword(String password){
        log.info("enter password :" +PassWord.toString());
    sendTextToElement(PassWord,password);
    }
    public void reEnterPassword(String confirmPassword){
        log.info("enter password again :" +ConfirmPassword.toString());
    sendTextToElement(ConfirmPassword,confirmPassword);
    }
    public void selectSubscribeButton(){
        log.info("select subscribe button:" +subscribeRadioButton.toString());
    clickOnElement(subscribeRadioButton);}
    public void selectPrivacyPolicy(){
        log.info("select privacy policy:" +privacyPolicy.toString());
    clickOnElement(privacyPolicy);}
    public void clickOnContinue(){
        log.info("click on continue button :" +continueButton.toString());
    clickOnElement(continueButton);}
    public void clickAgainOnContinue(){
        log.info("click on continue button :" +againContinueButton.toString());
    clickOnElement(againContinueButton);}
    public void clickOnLoginButton(){
        log.info("click on login button:" +loginButton.toString());
    clickOnElement(loginButton);}
    public String verifyUserLandedLoginPage(){
        log.info("verify Msg:" +verifyLoginMessage.toString());
    return getTextFromElement(verifyLoginMessage);}
}
