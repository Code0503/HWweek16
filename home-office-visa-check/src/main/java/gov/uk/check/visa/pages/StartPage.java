package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends Utility {
    private static final Logger log = LogManager.getLogger(StartPage.class.getName());
    public StartPage(){PageFactory.initElements(driver,this);}
    //Locators
    @CacheLookup
            @FindBy(xpath = "//section[@class='govuk-!-margin-bottom-6']/a")
    WebElement startNowButton;
   //By startNowButton = By.cssSelector("a[role='button']");
    @CacheLookup
           @FindBy(id = "response")
           WebElement SelectNationality;
   //By SelectNationality = By.id("response");
    @CacheLookup
           @FindBy(css ="button[class='gem-c-button govuk-button gem-c-button--bottom-margin']" )
           WebElement ContinueButton;
   //By ContinueButton = By.cssSelector("button[class='gem-c-button govuk-button gem-c-button--bottom-margin']");




   public void clickStartNow(){
     //  log.info("clicking on Start Now Button : " + startNowButton.toString());
       clickOnElement(startNowButton);
   }
   public void selectNationality(String nationality){
       log.info("select longer then 6 month radio button : " + SelectNationality.toString());
        selectByVisibleTextFromDropDown(SelectNationality,nationality);
    }
    public void clickOnContinueButton(){
       clickOnElement( ContinueButton);
    }

}
