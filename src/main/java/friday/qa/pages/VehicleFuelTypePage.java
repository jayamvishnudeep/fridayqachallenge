package friday.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleFuelTypePage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectFuelType";

    private WebDriver driver;
    private String fuel;


    //Initializing the Page Objects:
    public VehicleFuelTypePage(WebDriver driver, String fuel) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.fuel = fuel;
    }

    //Actions:

    public void clickOnselectFuelTypeBtn() {
        WebElement selectFuelTypeBtn = driver.findElement(By.xpath("//label[text()='" + fuel + "']"));
        selectFuelTypeBtn.click();
    }

    public void verifyFuelTypePage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

}

