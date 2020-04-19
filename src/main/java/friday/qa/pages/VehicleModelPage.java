package friday.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleModelPage {


    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectModel";


    private WebDriver driver;
    private String model;


    //Initializing the Page Objects:

    public VehicleModelPage(WebDriver driver, String model) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.model = model;
    }

    //Actions:
    public void clickOnselectModelBtn() {
        WebElement selectModelBtn = driver.findElement(By.xpath("//label[text()='" + model + "']"));
        selectModelBtn.click();
    }

    public void verifyModelPage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

}
