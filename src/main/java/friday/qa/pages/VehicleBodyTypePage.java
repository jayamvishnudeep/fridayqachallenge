package friday.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VehicleBodyTypePage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectBodyType";

    private WebDriver driver;
    private String body;


    @FindBy(xpath = "//label[text()='Coupe']")
    protected static WebElement selectBodyTypeBtn;


    //Initializing the Page Objects:

    public VehicleBodyTypePage(WebDriver driver, String body) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.body = body;
    }

    //Actions:

    public void clickOnselectBodyTypeBtn() {
        WebElement selectBodyTypeBtn = driver.findElement(By.xpath("//label[text()='" + body + "']"));
        selectBodyTypeBtn.click();
    }

    public void verifyBodyTypePage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }
}