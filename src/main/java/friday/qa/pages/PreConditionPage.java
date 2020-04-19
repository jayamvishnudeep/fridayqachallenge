package friday.qa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PreConditionPage {

    // Using page factory FindBy method to find all the elements in pre-condition page

    @FindBy(xpath = "//*[@id='uc-btn-accept-banner']")
    private static WebElement acceptCookiesBtn;

    @FindBy(xpath = "//button[@value='keepingCar']")
    private static WebElement changeInsurerBtn;

    @FindBy(xpath = "//button[@value='buyingCar']")
    private static WebElement changeOwnerBtn;

    @FindBy(xpath = "//form/p")
    private static WebElement firstHelpText;

    @FindBy(xpath = "//form/div/p")
    private static WebElement secondHelpText;

    @FindBy(xpath = "//input[@name='inceptionDate']")
    private static WebElement inceptionDate;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[2]/div/div/form/div[2]/div[2]/div[2]")
    private static WebElement dateValidation;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitBtn;

    @FindBy(xpath = "//*[@class='ValidationLabel__validationLabel--2km9U']/span")
    private static WebElement dateValidationMessage;


    private WebDriver driver;

    //Initializing the Page Objects:

    public PreConditionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions:

    public void clickOnAcceptCookiesBtn() {
        try {
            new WebDriverWait(driver, 2).until(arg0 -> {
                try {
                    if (acceptCookiesBtn.isDisplayed()) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Throwable e) {
                    return false;
                }
            });
            acceptCookiesBtn.click();
        } catch (TimeoutException ex) {
            // Cookies Accept popup box does not appeared
            // I am running tests in Incognito mode and so Cookies alert popup must be displayed every time,
            // but I noticed sometimes it's not being appeared.
        }
    }

    public void clickOnChangeInsurerBtn() {
        changeInsurerBtn.click();
    }

    public void clickOnPurchaseOrOwnerChangeBtn() {
        changeOwnerBtn.click();
    }

    public boolean validateFirstHelpText() {
        return firstHelpText.isDisplayed();
    }

    public boolean validateSecondHelpText() {
        return secondHelpText.isDisplayed();
    }

    public void fillInceptionDate(String date) {
        inceptionDate.sendKeys(date);
    }

    public void clickOnPreConditionsSubmitBtn() {
        submitBtn.click();
    }

    public void clearInceptionDate() {
        inceptionDate.clear();
    }

    public void verifyInceptionDateErrorInfo(String expectedMessage) {
        Assert.assertTrue(dateValidationMessage.isDisplayed());
        String actualMessage = dateValidationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
