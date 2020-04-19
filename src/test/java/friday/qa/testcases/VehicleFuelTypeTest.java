package friday.qa.testcases;

import friday.qa.pages.VehicleFuelTypePage;
import org.openqa.selenium.WebDriver;

public class VehicleFuelTypeTest {

    VehicleFuelTypePage vehicleFuelTypepage;

    public void selectFuelTypeTest(WebDriver driver, String fuel) {

        vehicleFuelTypepage = new VehicleFuelTypePage(driver, fuel);

        vehicleFuelTypepage.verifyFuelTypePage();
        vehicleFuelTypepage.clickOnselectFuelTypeBtn();

    }
}
