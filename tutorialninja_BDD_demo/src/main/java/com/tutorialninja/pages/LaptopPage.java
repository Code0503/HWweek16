package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopPage.class.getName());
    public LaptopPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
            @FindBy(xpath = "//div[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
    WebElement Qty;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']//button")
    WebElement UpdateButton;
    @CacheLookup
            @FindBy(xpath ="//div[@id='content']//tbody/tr/td[6]" )
    WebElement TotalPrice;
    @CacheLookup
            @FindBy(xpath = "//div[@id='content']/div[3]/div[2]")
    WebElement CheckOut;
    @CacheLookup
            @FindBy (xpath ="//div[@id='checkout-checkout']/div/div/h1" )
   WebElement CheckOutText;
    @CacheLookup
            @FindBy(xpath ="//div[@id=\"collapse-checkout-option\"]/div/div/div[1]/h2")
    WebElement NewUserText;
    @CacheLookup
            @FindBy(xpath ="//div[@id='checkout-checkout']/div/div/div/div/div[2]/div/div/div/div[2]/label/input" )
   WebElement GuestButton;
    @CacheLookup
            @FindBy(id = "button-account")
    WebElement ContinueButton;
    @CacheLookup
            @FindBy(name ="firstname" )
    WebElement FirstName;
    @CacheLookup
            @FindBy(name ="lastname" )
    WebElement LastName;
    @CacheLookup@FindBy(id ="input-payment-email" )
    WebElement Email;
    @CacheLookup
            @FindBy(name = "telephone")
    WebElement TelephoneNo;
    @CacheLookup
            @FindBy(id = "input-payment-address-1")
    WebElement Address;
    @CacheLookup
            @FindBy(id ="input-payment-city" )
    WebElement City;
    @CacheLookup
            @FindBy(id = "input-payment-postcode")
    WebElement PostCode;
    @CacheLookup
            @FindBy(id ="input-payment-country" )
    WebElement Country;
    @CacheLookup
            @FindBy(id ="input-payment-zone" )
    WebElement Region;
    @CacheLookup
            @FindBy(id ="button-guest" )
    WebElement nextButton;
    @CacheLookup
            @FindBy(name ="agree" )
    WebElement tAndc;
    @CacheLookup
            @FindBy(id = "button-payment-method")
    WebElement paymentButton;
    @CacheLookup
            @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement verifyWarningMessage;




    public void updateQty(String qty){
        log.info("update qty of the product :"+Qty.toString());
        Qty.clear();
        sendTextToElement(Qty,qty);
    }
    public void clickOnQtyUpdate(){
        log.info("click on update qty button :"+UpdateButton.toString());
        clickOnElement(UpdateButton);
    }
    public String verifyTotalPrice(){
        log.info("Verify Total price :"+TotalPrice.toString());
        return getTextFromElement(TotalPrice);
    }
    public void clickOnCheckOutButton(){
        log.info("click on check out button :"+CheckOut.toString());
        clickOnElement(CheckOut);
    }

    public String verifyUserOnCheckOutPage(){
        log.info("Verify user on check out page:"+CheckOutText.toString());
        return getTextFromElement(CheckOutText);
    }
    public String verifyNewUserMsg(){
        log.info("Verify New user text:"+NewUserText.toString());
        return getTextFromElement(NewUserText);
    }
    public void selectRadioButtonGuest(){
        log.info("select guest button :"+ GuestButton.toString());
        clickOnElement(GuestButton);
    }
    public void clickOnContinueButton(){
        log.info("click on continue button :"+ContinueButton.toString());
        clickOnElement(ContinueButton);
    }
    public void enterFirstname(String firstName){
        log.info("enter user first name :"+ FirstName.toString());
        sendTextToElement(FirstName,firstName);
    }
    public void enterLastname(String lasttName){
        log.info("enter user last name : "+ LastName.toString());
        sendTextToElement(LastName,lasttName);
    }
    public void enterEmail(String email){
        log.info("enter user email : "+ Email.toString());
        sendTextToElement(Email,email);
    }
    public void enterTelephoneNumber(String telephoneNo){
        log.info("enter user Phone number : "+TelephoneNo.toString());
        sendTextToElement(TelephoneNo,telephoneNo);
    }
    public void enterAddress(String address){
        log.info("enter user Address :"+ Address.toString());
        sendTextToElement(Address,address);
    }
    public void enterCityname(String city){
        log.info("enter user city :"+ City.toString());
        sendTextToElement(City,city);
    }
    public void enterPostCode(String postcode){
        log.info("enter user postcode :"+ PostCode.toString());
        sendTextToElement(PostCode,postcode);
    }
    public void enterCountry(String countryName){
        log.info("enter user country :"+ Country.toString());
        selectByVisibleTextFromDropDown(Country,countryName);}
    public void enterRegion(String State){
        log.info("enter user region :"+ Region.toString());
        selectByVisibleTextFromDropDown(Region,State);
    }
    public void clickOnGuestButton(){
        log.info("Click on guest button :"+ nextButton.toString());
        clickOnElement(nextButton);
    }
    public void clickOnAgreeTermsAndConditions() throws InterruptedException {
        log.info("select terms and conditions  :"+ tAndc.toString());
        Thread.sleep(500);
        clickOnElement(tAndc);
    }
    public void clickOnPaymentButton(){
        log.info("click on payment button :"+ paymentButton.toString());
        clickOnElement(paymentButton);
    }
    public String veryfiyPaymentMessage(){
        log.info("verify payment message :"+ verifyWarningMessage.toString());
        return getTextFromElement(verifyWarningMessage);
    }

}
