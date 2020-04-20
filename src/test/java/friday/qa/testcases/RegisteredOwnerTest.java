package friday.qa.testcases;

import friday.qa.base.TestBase;
import friday.qa.pages.VehicleRegisteredOwnerPage;
import org.openqa.selenium.WebDriver;


public class RegisteredOwnerTest {
    VehicleRegisteredOwnerPage vehicleRegisteredOwnerPage;


    public void fillRegisteredOwnerTest(WebDriver driver) {

        vehicleRegisteredOwnerPage = new VehicleRegisteredOwnerPage(driver);

        vehicleRegisteredOwnerPage.clickOnCarOwnerNoBtn();
        vehicleRegisteredOwnerPage.clickOnCarOwnerYesBtn();
        vehicleRegisteredOwnerPage.clickOnUsedCarBtn();
        vehicleRegisteredOwnerPage.clickOnNewCarBtn();
        vehicleRegisteredOwnerPage.clickOnRegisteredOwnerSubmitBtn();

    }
}
