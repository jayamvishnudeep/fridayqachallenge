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

public class SelectVehiclePage {

    private static final String EXPECTED_URL = "https://hello.friday.de/quote/selectVehicle";

    private WebDriver driver;

    private String brandName;
    private String hsn;
    private String tsn;
    private String firstRegistrationDate;

    // Using page factory FindBy method to find all the elements in pre-condition page

    @FindBy(xpath = "//*[@name='hsnTsn']")
    private static WebElement hsnTsnBtn;

    @FindBy(xpath = "//*[@name='monthYear']")
    private static WebElement firstRegistrationDateInput;

    @FindBy(xpath = "//*[@name='hsn']")
    private static WebElement hsnInput;

    @FindBy(xpath = "//*[@name='tsn']")
    private static WebElement tsnInput;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement submitBtn;

    @FindBy(xpath = "//*[@name='makeFilter']")
    private static WebElement searchVehicleBrandFilter;

    //Initializing the Page Objects:

    public SelectVehiclePage(WebDriver driver, String brandName) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.brandName = brandName;
    }

    public SelectVehiclePage(WebDriver driver, String hsn, String tsn, String firstRegistrationDate) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.hsn = hsn;
        this.tsn = tsn;
        this.firstRegistrationDate = firstRegistrationDate;
    }

    //Actions:

    public void fillVehicleBrandFilter(String filter) {
        searchVehicleBrandFilter.sendKeys(filter);
    }


    public void clickOnselectBrandBtn() {
        WebElement selectBrandBtn = driver.findElement(By.xpath("//label[text()='" + brandName + "']"));
        selectBrandBtn.click();
    }

    public void verifySelectVehiclePage() {
        try {
            new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe(EXPECTED_URL));
        } catch (TimeoutException ex) {
            Assert.fail("Unable to reach " + EXPECTED_URL);
        }
    }

    public void clickOnHsnTsnBtnBtn() {
        hsnTsnBtn.click();
    }

    public void fillFirstRegistrationDate() {
        firstRegistrationDateInput.sendKeys(firstRegistrationDate);
    }

    public void fillHsn() {
        hsnInput.sendKeys(hsn);
    }

    public void fillTsn() {
        tsnInput.sendKeys(tsn);
    }

    public void clickOnHsnTsnSubmitBtn() {
        submitBtn.click();
    }

}
