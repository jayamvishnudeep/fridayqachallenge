package friday.qa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShowHsnTsnCarPage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/showHsnTsnCar";

    private WebDriver driver;
    private String expectedHsnTsnVehicleDetails;


    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitBtn;

    @FindBy(xpath = "//*[@data-test-id='carLabel']")
    private static WebElement hsnTsnVehicleDetailsLabel;


    //Initializing the Page Objects:

    public ShowHsnTsnCarPage(WebDriver driver, String expectedHsnTsnVehicleDetails) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.expectedHsnTsnVehicleDetails = expectedHsnTsnVehicleDetails;
    }

    //Actions:

    public void verifyHsnTsnVehicleDetails() {
        try {
            new WebDriverWait(driver, 2).until(arg0 -> {
                try {
                    if (hsnTsnVehicleDetailsLabel.isDisplayed()) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (Throwable e) {
                    return false;
                }
            });
        } catch (TimeoutException ex) {
            Assert.fail("Unable to render hsn tsn vehicle details");
        }

        String actualVehicleDetails = hsnTsnVehicleDetailsLabel.getText();
        Assert.assertEquals(actualVehicleDetails, expectedHsnTsnVehicleDetails);
    }

    public void verifyShowHsnTsnPage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

    public void clickOnShowHsnTsnConfirmationBtn() {
        submitBtn.click();
    }

}
