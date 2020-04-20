package friday.qa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleRegisteredOwnerPage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectRegisteredOwner";

    private WebDriver driver;

    // Using page factory FindBy method to find all the elements in this page

    @FindBy(xpath = "//button[@data-test-id='shared.yes']")
    protected static WebElement carOwnerYesBtn;

    @FindBy(xpath = "//button[@data-test-id='shared.no']")
    protected static WebElement carOwnerNoBtn;


    @FindBy(xpath = "//button[@data-test-id='quoting.selectRegisteredOwner.used']")
    protected static WebElement usedCarBtn;

    @FindBy(xpath = "//button[@data-test-id='quoting.selectRegisteredOwner.brandNew']")
    protected static WebElement newCarBtn;


    @FindBy(xpath = "//button[@type='submit']")
    protected static WebElement submitBtn;

    //Initializing the Page Objects:

    public VehicleRegisteredOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions:

    public void clickOnCarOwnerYesBtn() {
        carOwnerYesBtn.click();
    }

    public void clickOnCarOwnerNoBtn() {
        carOwnerNoBtn.click();
    }

    public void clickOnUsedCarBtn() {
        usedCarBtn.click();
    }

    public void clickOnNewCarBtn() {
        newCarBtn.click();
    }

    public void clickOnRegisteredOwnerSubmitBtn() {
        submitBtn.click();
    }

}
