package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReasonForTravel extends Utility {
    private static final Logger log = LogManager.getLogger(ReasonForTravel.class.getName());
    public ReasonForTravel(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
       @FindBy(xpath = "//div[@class='govuk-radios']/div")
    List<WebElement> reasonForVisitList;

    @CacheLookup
       @FindBy(xpath ="//fieldset[@class='govuk-fieldset']/div[@class='govuk-radios']/div/label" )
    List<WebElement> typeOfJob;

    @CacheLookup
            @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
            WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement NextButton;

    @CacheLookup
            @FindBy(id = "response-1")
            WebElement planningToStay;
    //By planningToStay = By.id("response-1");

    public void selectReasonForTravel(String reason) {
        log.info("select Reason for travel : " + reasonForVisitList.toString());
        //  1.2 This method should click on the options whatever name is passed as parameter. (Hint: Handle List of Element and Select options)
        List<WebElement> listofnames =  reasonForVisitList;
        for (WebElement element : listofnames) {
            if (element.getText().equalsIgnoreCase(reason)) {
                element.click();
            }
        }
    }

    public void selectTypeOfJob(String JobType) {
        log.info("select longer then 6 month radio button : " + typeOfJob.toString());
        //  1.2 This method should click on the options whatever name is passed as parameter. (Hint: Handle List of Element and Select options)
        List<WebElement> listofreasons = typeOfJob;
        for (WebElement element : listofreasons) {
            if (element.getText().equalsIgnoreCase(JobType)) {
                element.click();
            }
        }
    }


        public void selectPlanningToStay (String Plan){
            log.info("select longer then 6 month radio button : " + planningToStay.toString());
            clickOnElement(planningToStay);

        }
    public void clickOnNextStepButton () {
        clickOnElement(NextButton);
    }
    public void clickNextStepButton () {
        clickOnElement(continueButton);
    }
    }
