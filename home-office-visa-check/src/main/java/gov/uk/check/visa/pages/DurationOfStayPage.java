package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DurationOfStayPage extends Utility {
    private static final Logger log = LogManager.getLogger(DurationOfStayPage.class.getName());

    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }// error to come alert
    @CacheLookup
            @FindBy(xpath = "(//div[@class='govuk-radios']/div/label)[1]")
    WebElement lessThanSixMonth;
   // By lessThanSixMonth=By.xpath("(//div[@class='govuk-radios']/div/label)[1]");
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']/div[2]/label")
    WebElement morethan6months;
    //By morethan6months = By.xpath("//div[@class='govuk-radios']/div[2]/label");
    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement NextButton;
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void selectLengthOfStay(String moreOrLess){
        log.info("select longer then 6 month radio button : " + morethan6months.toString());

        switch (moreOrLess){
            case "longer than 6 months":
                morethan6months.click();

                break;

            case "6 months or less":
                lessThanSixMonth.click();
                break;
            default:
                System.out.println("not found");
        }
        clickOnElement(NextButton);
    }


}
