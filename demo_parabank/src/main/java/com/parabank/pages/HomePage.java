package com.parabank.pages;

import com.parabank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy (linkText = "Log in")
    WebElement Login;
    @CacheLookup
    @FindBy (xpath = "//div[@id='loginPanel']/p[2]/a")
    WebElement registerLink;

public void clickOnLogin(){
    log.info("Click on login button : " +Login.toString());
    clickOnElement(Login);
}
public void clickOnRegisterTab(){
    log.info("Click on register tab :" +registerLink.toString());
}

}
