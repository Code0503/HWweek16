package com.tutorialninja.cucumber.steps;

import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopPage;
import com.tutorialninja.pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class TestStepdefs {
    @Given("^user on home page$")
    public void userOnHomePage() {
    }

    @When("^user select top menu bar \"([^\"]*)\"$")
    public void userSelectTopMenuBar(String topMe) {
       new HomePage().selectTopMenu(topMe);
    }

    @And("^click on tab menu item \"([^\"]*)\"$")
    public void clickOnTabMenuItem(String menuitem)  {
        new HomePage().selectMenu(menuitem);
    }

    @And("^product list Short by \"([^\"]*)\"$")
    public void productListShortBy(String shortby)  {
       new HomePage().selectSortBy(shortby);
    }

    @And("^select product \"([^\"]*)\"$")
    public void selectProduct(String product)  {
      new HomePage().selectProduct(product);
    }

    @Then("^verify selected product \"([^\"]*)\"$")
    public void verifySelectedProduct(String name) throws InterruptedException {
        Assert.assertEquals(name,new HomePage().verifyProductName(),"product name not matching");
    }

    @And("^select delivery date  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void selectDeliveryDate(String year, String month, String date) throws InterruptedException {
        new HomePage().selectDeliveryDate("2023","July","15");
    }

    @And("^update Qty to cart \"([^\"]*)\"$")
    public void updateQtyToCart(String QTY){
new HomePage().updateQty(QTY);
    }

    @And("^click add to cart button$")
    public void clickAddToCartButton() {
        new HomePage().addProductToCart();
    }


    @And("^change currency in to \"([^\"]*)\"$")
    public void changeCurrencyInTo(String GBP)  {
      new HomePage().selectCurrency(GBP);
    }

    @And("^click on shopping cart$")
    public void clickOnShoppingCart() {
        new HomePage().clickOnShoppigCart();
    }

    @Then("^verify product name in shoping cart \"([^\"]*)\"$")
    public void verifyProductNameInShopingCart(String pruductName) {
       Assert.assertEquals(pruductName,new HomePage().verifyProduct(),"product name doesnt match");
    }

    @Then("^verify delivery date \"([^\"]*)\"$")
    public void verifyDeliveryDate(String dateOfDelivery)  {
        Assert.assertEquals(dateOfDelivery,new HomePage().verifyDeliveryDate(),"Delivery date doesnt match");
    }

    @Then("^verify product model \"([^\"]*)\"$")
    public void verifyProductModel(String model) {
        Assert.assertEquals(model,new HomePage().verifyModel(),"model name doesnt match");
    }

    @Then("^verify unit price \"([^\"]*)\"$")
    public void verifyUnitPrice(String unitPrice)  {
        Assert.assertEquals(unitPrice,new HomePage().verifyUnitPrice(),"Unit price doesnt match");
    }

    @And("^update product qty \"([^\"]*)\"$")
    public void updateProductQty(String qty) {
       new LaptopPage().updateQty(qty);
    }

    @And("^click on product update button$")
    public void clickOnProductUpdateButton() {
        new LaptopPage().clickOnQtyUpdate();
    }

    @Then("^verify total price \"([^\"]*)\"$")
    public void verifyTotalPrice(String totalPrice) {
       Assert.assertEquals(totalPrice,new LaptopPage().verifyTotalPrice(),"Total price does not match");
    }

    @And("^click on checkout button$")
    public void clickOnCheckoutButton() {
        new LaptopPage().clickOnCheckOutButton();
    }

    @Then("^verify user on check out page \"([^\"]*)\"$")
    public void verifyUserOnCheckOutPage(String expected) {
        Assert.assertEquals(expected,new LaptopPage().verifyUserOnCheckOutPage(),"user not on check out page");
    }

    @Then("^verify user on New user page \"([^\"]*)\"$")
    public void verifyUserOnNewUserPage(String newUser) throws InterruptedException {
        Thread.sleep(2000L);
        Assert.assertEquals(newUser,new LaptopPage().verifyNewUserMsg(),"Text does not match");
    }

    @And("^select guest radio button$")
    public void selectGuestRadioButton() {
        new LaptopPage().selectRadioButtonGuest();
    }

    @And("^click on continue button$")
    public void clickOnContinueButton() {
        new LaptopPage().clickOnContinueButton();
    }

    @And("^user enter first name \"([^\"]*)\"$")
    public void userEnterFirstName(String fName) {
       new LaptopPage().enterFirstname(fName);
    }

    @And("^user enter last name \"([^\"]*)\"$")
    public void userEnterLastName(String lname) {
       new LaptopPage().enterLastname(lname);
    }

    @And("^user enters email \"([^\"]*)\"$")
    public void userEntersEmail(String mail) {
       new LaptopPage().enterEmail(mail);
    }

    @And("^user enters telephone number \"([^\"]*)\"$")
    public void userEntersTelephoneNumber(String pnumber) {
       new LaptopPage().enterTelephoneNumber(pnumber);
    }

    @And("^user enters Address \"([^\"]*)\"$")
    public void userEntersAddress(String address) {
       new LaptopPage().enterAddress(address);
    }

    @And("^user enters city name \"([^\"]*)\"$")
    public void userEntersCityName(String nameOfCity) {
       new LaptopPage().enterCityname(nameOfCity);
    }

    @And("^user enters postcode \"([^\"]*)\"$")
    public void userEntersPostcode(String zipcode) {
       new LaptopPage().enterPostCode(zipcode);
    }

    @And("^user enter country \"([^\"]*)\"$")
    public void userEnterCountry(String nameOfCountry) {
       new LaptopPage().enterCountry(nameOfCountry);
    }

    @And("^user enter state name \"([^\"]*)\"$")
    public void userEnterStateName(String region) {
        new LaptopPage().enterRegion(region);

    }

    @And("^user select guest button$")
    public void userSelectGuestButton() {
        new LaptopPage().clickOnGuestButton();
    }

    @And("^user selects Terms and condition$")
    public void userSelectsTermsAndCondition() throws InterruptedException {
        new LaptopPage().clickOnAgreeTermsAndConditions();
    }

    @And("^user click on payment button$")
    public void userClickOnPaymentButton() {
        new LaptopPage().clickOnPaymentButton();
    }

    @When("^user click on my account tab and select \"([^\"]*)\"$")
    public void userClickOnMyAccountTabAndSelect(String nameOfAcc) {
        new MyAccountPage().clickOnMyAccountAndSelectOption(nameOfAcc);
    }

    @Then("^verify user on register account page by text \"([^\"]*)\"$")
    public void verifyUserOnRegisterAccountPageByText(String expectedText) {
        Assert.assertEquals(expectedText,new MyAccountPage().verifyUserOnRegisterAccountPage(),"Text not matching");
    }

    @And("^user enters an emailFirstName \"([^\"]*)\"$")
    public void userEntersAnEmailFirstName(String emailFname) {
        new MyAccountPage().enterAnEmail(emailFname);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String pasWord) {
       new MyAccountPage().enterPassword(pasWord);
    }

    @And("^user enters reConfirm password \"([^\"]*)\"$")
    public void userEntersReConfirmPassword(String repasWord) {
        new MyAccountPage().reEnterPassword(repasWord);

    }

    @And("^user select the subscribe option$")
    public void userSelectTheSubscribeOption() {
        new MyAccountPage().selectSubscribeButton();
    }

    @And("^user selects Terms conditions$")
    public void userSelectsTermsConditions() {
        new MyAccountPage().selectPrivacyPolicy();
    }

    @And("^user click on countinue button$")
    public void userClickOnCountinueButton() {
        new MyAccountPage().clickOnContinue();
    }


    @And("^user click on logout button \"([^\"]*)\"$")
    public void userClickOnLogoutButton(String logout)  {
       new MyAccountPage().clickOnMyAccountAndSelectOption(logout);
    }

    @And("^user click on continue button$")
    public void userClickOnContinueButton() {
        new MyAccountPage().clickAgainOnContinue();
    }



//    @Then("^verify payment message \"([^\"]*)\"$")
//    public void verifyPaymentMessage(String expected) {
//    Assert.assertEquals(expected, new LaptopPage().veryfiyPaymentMessage(),"Msg does not match");
//    }
}
