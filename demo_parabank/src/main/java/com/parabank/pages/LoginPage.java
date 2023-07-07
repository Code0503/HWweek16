package com.parabank.demo.pages;

import com.parabank.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }// error to come alert
    @CacheLookup
            @FindBy(xpath ="//h1[contains(text(),'Welcome, Please Sign In!')]" )
    WebElement welcomeText;
    @CacheLookup
            @FindBy(id="Email")
    WebElement emailfield;

    @CacheLookup
            @FindBy(name="Password")
    WebElement passwordField;
    @CacheLookup
            @FindBy(css="input[class='button']")
    WebElement loginButton;
    @CacheLookup
            @FindBy(xpath="//div[@class='message-error validation-summary-errors']")
    WebElement errorMag;
    @CacheLookup
            @FindBy (name="username")
    WebElement EnterUsername;
    @CacheLookup
            @FindBy (name="password")
    WebElement EnterPassword;

    @CacheLookup
            @FindBy (linkText="Log Out")
    WebElement LogoutButton;
    @CacheLookup
    @FindBy (css="h1[class='title']")
    WebElement VerifyLoginText;
    @CacheLookup
    @FindBy (css="div#leftPanel>h2")
    WebElement VerifyLogoutText;

    public String getWelcomeText() {
        log.info("Get welcome text" + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void enterEmailId(String email) {
        log.info("Enter email id :"+ email.toString());
        sendTextToElement(emailfield, email);
    }

    public void enterPassword(String password) {

        log.info("Provide an  data to email field :"+password.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("click on login button");clickOnElement(loginButton);
    }
    public void clickOnLogoutButton() {
        Reporter.log("click on logout button");clickOnElement(LogoutButton);
    }

    public String getErrorMessage() {
        return getTextFromElement(errorMag);
    }


    public void loginToApplication(String username, String password) {
        log.info("Enter username :"+username.toString());
        sendTextToElement(EnterUsername,username);
        log.info("Enter username :"+password.toString());
        sendTextToElement(EnterPassword,password);
    }
    public void verifyUserIsLogin(String expected){
        verifyText(expected,VerifyLoginText);
    }
    public void verifyUserLogedOut(String expected){
        verifyText(expected,VerifyLogoutText);
    }



}
