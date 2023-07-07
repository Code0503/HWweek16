package com.tutorialninja.pages;


import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
//    By MenuBar = By.xpath("//ul[@class='nav navbar-nav']/li");
//    By TabName = By.xpath("//ul[@class='nav navbar-nav']/li/div/a");
//
//
//    public void selectMenu(String menu){
//      driver.findElement(MenuBar).getText().equalsIgnoreCase(menu);
//
//       driver.findElement(TabName).equals(menu);
//    }
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage() {
        PageFactory.initElements(driver, this);
    }// error to come alert
    @CacheLookup
            @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
WebElement MenuBar;
    @CacheLookup
            @FindBy(xpath ="//div[@class='dropdown-menu']/a" )
    WebElement TabName;
    @CacheLookup
    @FindBy(css = "div#content>h2")
    WebElement ProductSelected;
    @CacheLookup
    @FindBy(css = "form#form-currency>div>button>span")
    WebElement currency;
    @CacheLookup
    @FindBy(name ="GBP" )
    WebElement currencyName;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement SortBy;
    @CacheLookup
    @FindBy(xpath = "(//select[@id='input-sort']/option)[3]")
    WebElement ZtoA;

    @CacheLookup
    @FindBy (xpath = "//div[@id='content']/div/div[2]/h1")
    WebElement verifyName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']/span/button")
    WebElement selectDeliveryDate;
    @CacheLookup
    @FindBy(xpath ="//div[3]/div/div[1]/table/thead/tr[1]/th[2]" )
    WebElement monthAndYear;
    //By Date= By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[4]/td[3]");
    @CacheLookup
    @FindBy(xpath = "/html/body/div[3]/div/div[1]/table/tbody/tr/td")
   List <WebElement> Date;
    @CacheLookup
    @FindBy(xpath = "//div[@id='product']/div[2]/input")
    WebElement Qty;
    @CacheLookup
    @FindBy(id ="button-cart")
    WebElement addToCart;
    @CacheLookup
    @FindBy(linkText = "Shopping Cart")
    WebElement ShoppingCart;
    @CacheLookup
    @FindBy (xpath = "//div[@id='content']/div/div[2]/h1")
    WebElement verifyProductName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SucessCartMsg;





    public void selectTopMenu(String menu) {
        log.info("Mouse hover on Top mneu bar :" +MenuBar.toString());
        mouseHoverToElement(MenuBar);
    }
    public void selectMenu( String menuItem) {
        log.info("Select tab name from tab menu :" +TabName.toString());
        mouseHoverToElementAndClick(TabName);
    }
public void selectSortBy(String shrotBy){
    log.info("Shor product by :" +SortBy.toString());
        selectByVisibleTextFromDropDown(SortBy,shrotBy);

}

    @CacheLookup
    @FindBy(xpath ="//div[@class='caption']/h4/a" )
   List<WebElement> ProductName;



    public String selectProduct(String nameOfProduct) throws StaleElementReferenceException {
        log.info("select product : " + ProductName.toString());
        //  1.2 This method should click on the options whatever name is passed as parameter. (Hint: Handle List of Element and Select options)
        List<WebElement> listofnames = ProductName;

        try {
            for (WebElement element : listofnames) {
                if (element.getText().equalsIgnoreCase(nameOfProduct)) {
                    element.click();
                }
            }
            } catch(StaleElementReferenceException exception){
                listofnames = ProductName;
            }

        return nameOfProduct;
    }



    public String verifyProductName() {
        log.info("Verify selected product name :" +verifyName.toString());
        return getTextFromElement(verifyName);
    }
public String verifySelectedProductName(){
    log.info("Verify selected product name :" +verifyProductName.toString());
        return getTextFromElement(verifyProductName);
}


//public void verifyProductScuessfullyAdded(String expectedMessage){
//        verifyText(expectedMessage,By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//}
public void selectDeliveryDate(String year, String month, String date) throws InterruptedException {
    //date picker

    log.info("select date for delivery  :" +selectDeliveryDate.toString());
       selectDeliveryDate.click();

     //Below selecting Month and Year from list
        while (true) {
            String monthyear = monthAndYear.getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String year1 = arr[1];

            if (mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[3]/div/div[1]/table/thead/tr[1]/th[3]"));
            }
        }
        Thread.sleep(2000);
     //Below is selecting date from list
    //below Stale exception  handling method as during runtime website generates problem
    List<WebElement> topMenuList = Date;
    try {
        for (WebElement element : topMenuList) {
            if (element.getText().equalsIgnoreCase(date)) {
                element.click();
            }
        }}
    catch (StaleElementReferenceException e) {
        topMenuList = Date;
    }
}

public void updateQty(String qty){
    log.info("update qty :" +Qty.toString());
        Qty.clear();
        sendTextToElement(Qty,qty);
}

public void addProductToCart(){
    log.info("click on add to cart button :" +addToCart.toString());
        clickOnElement(addToCart);
}
    public String verifyProductAddedToCart(){
        log.info("Verify product is added to card:" +SucessCartMsg.toString());
        return getTextFromElement(SucessCartMsg);
    }

public void selectCurrency(String Currency){
    log.info("click on change currency tab:" +currency.toString());
    log.info("select currency from tab:" +currencyName.toString());
        clickOnElement(currency);
        clickOnElement(currencyName);
}
public void clickOnShoppigCart(){
    log.info("click on shopping cart:" +ShoppingCart.toString());
        clickOnElement(ShoppingCart);
}
    @CacheLookup @FindBy (xpath ="//div[@id='checkout-cart']/div//form//td[2]/a" )
    WebElement productName;


//verify product name in shopping cart
    public String verifyProduct(){
        log.info("verify product name in shopping cart:" +productName.toString());
       return getTextFromElement(productName);
    }
    //Verify delivery date
    @CacheLookup@FindBy(xpath ="//div[@id='checkout-cart']/div//form//td[2]/small" )
    WebElement deliveryDate;
    public String verifyDeliveryDate(){
        log.info("verify delivery date:" +deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }
    //Verify Model of the product from grid
    @CacheLookup@FindBy(xpath ="//div[@id='checkout-cart']/div//form//tbody//td[3]" )
    WebElement productModel;
    public String verifyModel(){
        log.info("verify product Model:" +productModel.toString());
        return getTextFromElement(productModel);
    }
    //Verify Unit Price of the product from grid
    @CacheLookup@FindBy(xpath ="//div[@id='checkout-cart']/div//form//tbody//td[5]" )
    WebElement UnitPrice;
    public String verifyUnitPrice(){
        log.info("verify product unit price:" +UnitPrice.toString());
        return  getTextFromElement(UnitPrice);
    }
}
