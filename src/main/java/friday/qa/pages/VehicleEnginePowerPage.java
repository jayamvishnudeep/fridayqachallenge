package friday.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleEnginePowerPage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectEnginePower";


    private WebDriver driver;
    private String enginePower;


    //Initializing the Page Objects:
    public VehicleEnginePowerPage(WebDriver driver, String enginePower) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.enginePower = enginePower;
    }

    //Actions:

    public void clickOnselectEnginePowerBtn() {
        WebElement selectEngineBtn = driver.findElement(By.xpath("//label[text()='" + enginePower + "']"));
        selectEngineBtn.click();
    }

    public void verifyEnginePowerPage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

}
