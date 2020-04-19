package friday.qa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BirthDetailsPage {


    private static final String EXPECTED_URL = "https://hello.friday.de/quote/enterBirthDate";

    private WebDriver driver;

    //Initializing the Page Objects:

    public BirthDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Actions:

    public void verifyBirthDetailsPage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }
}