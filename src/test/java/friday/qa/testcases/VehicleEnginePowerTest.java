package friday.qa.testcases;

import friday.qa.pages.VehicleEnginePowerPage;
import org.openqa.selenium.WebDriver;

public class VehicleEnginePowerTest {

    VehicleEnginePowerPage vehicleEnginePowerpage;

    public void selectCarEnginePowerTest(WebDriver driver, String enginePower) {

        vehicleEnginePowerpage = new VehicleEnginePowerPage(driver, enginePower);

        vehicleEnginePowerpage.verifyEnginePowerPage();
        vehicleEnginePowerpage.clickOnselectEnginePowerBtn();

    }
}
