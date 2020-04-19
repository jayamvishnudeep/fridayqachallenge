package friday.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleEnginePage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectEngine";

    private WebDriver driver;
    private String carEngine;

    //Initializing the Page Objects:
    public VehicleEnginePage(WebDriver driver, String carEngine) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.carEngine = carEngine;
    }

    //Actions:
    public void clickOnselectEngineBtn() {
        WebElement selectCarBtn = driver.findElement(By.xpath("//label[text()='" + carEngine + "']"));
        selectCarBtn.click();
    }

    public void verifyEnginePage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

}