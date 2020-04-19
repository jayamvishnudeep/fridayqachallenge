package friday.qa.pages;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleRegistrationDatePage {


    private static final String EXPECTED_URL = "https://hello.friday.de/quote/enterRegistrationDate";

    private WebDriver driver;

    // Using page factory FindBy method to find all the elements in this page

    @FindBy(xpath = "//input[@name='monthYearFirstRegistered']")
    private static WebElement registrationDate;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitBtn;

    @FindBy(xpath = "//*[@class='ValidationLabel__validationLabel--2km9U']")
    private static WebElement dateValidationMessage;


    //Initializing the Page Objects:

    public VehicleRegistrationDatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions:

    public void fillRegistrationDate(String date) {
        registrationDate.sendKeys(date);
    }

    public void verifyRegistrationDatePage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

    public void clickOnRegistrationDateSubmitBtn() {
        submitBtn.click();
    }

    public void verifyFirstRegistrationDateErrorInfo() {
        Assert.assertTrue(dateValidationMessage.isDisplayed());
    }
    public void clearRegistrationDate() {
        registrationDate.clear();
    }

}
