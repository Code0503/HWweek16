package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends Utility {
    private static final Logger log = LogManager.getLogger(ResultPage.class.getName());
    public ResultPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
            @FindBy(css = "div[class='govuk-!-margin-bottom-6']>h2")
    WebElement resultText;
    //By resultText = By.cssSelector("div[class='govuk-!-margin-bottom-6']>h2");
    public void confirmResultMessage(String expectedMessage){
        log.info("Verify Message: " + resultText.toString());
        verifyThatTextIsDisplayed(resultText,expectedMessage);
        //Assert.assertTrue(getResultMessage().equalsIgnoreCase(expectedMessage));
    }
//    public String getResultMessage(){
//        return driver.findElement( resultText).getText();
//    }

}
