package uk.co.library.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.utility.Utility;


public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(css = "h1[class='search-header__title']")
    WebElement resultText;
    public void verifyTheResults(String expected){
        log.info("Verify message  : " + resultText.toString());
        verifyText(expected,resultText);
    }


    @CacheLookup
            @FindBy(id="keywords")
    WebElement JobTitle;
    @CacheLookup
            @FindBy(css ="div[class='home-search hps-transition'] input[name='geo']" )
            WebElement Location;
    @CacheLookup
    @FindBy(id="distance")
            WebElement Distance;
    @CacheLookup
            @FindBy (id = "toggle-hp-search")
            WebElement MoreOptions;
    @CacheLookup
    @FindBy(id ="salarymin" )
            WebElement SalaryMin;
    @CacheLookup
            @FindBy (id ="salarymax")
            WebElement SalaryMax;
   @CacheLookup
           @FindBy (css = "select[id='salarytype']")
           WebElement SalaryType;
    @CacheLookup
            @FindBy (css = "select#tempperm")
            WebElement JobType;
    @CacheLookup
            @FindBy(css ="input[type='submit']" )
            WebElement FindJobButton;


    public void EnterJobTitle(String jobTitle){
        log.info("Enter job title  : " + JobTitle.toString());
        sendTextToElement(JobTitle,jobTitle);
    }
    public void EnterLocation(String location){
        log.info("Enter job search location" +Location.toString());
        sendTextToElement(Location,location);
    }
    public void selectDistance(String distance){
        log.info("Enter distance for job " +Distance.toString());
        selectByContainsTextFromDropDown(Distance,distance);

    }
    public void clickOnMoreSearchOptionLink(){
        clickOnElement(MoreOptions);
    }
    public void enterMinSalary(String minSalary){
        log.info("Enter minimum salary " +SalaryMin.toString());
        sendTextToElement(SalaryMin,minSalary);
    }
    public void enterMaxSalary(String maxSalary){
        log.info("Enter max salary  " +SalaryMax.toString());
        sendTextToElement(SalaryMax,maxSalary);
    }
    public void selectSalaryType(String salaryType){
        log.info("Selecting salary type " +SalaryType.toString());
        selectByVisibleTextFromDropDown(SalaryType,salaryType);
    }
    public void selectJobType(String jobType){
        log.info("Select job type" +JobType.toString());
        selectByVisibleTextFromDropDown(JobType,jobType);
    }
    public void clickOnFindJobsButton(){
        clickOnElement(FindJobButton);
    }

}
