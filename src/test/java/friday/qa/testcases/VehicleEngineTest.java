package friday.qa.testcases;

import friday.qa.pages.VehicleEnginePage;
import org.openqa.selenium.WebDriver;

public class VehicleEngineTest {

    VehicleEnginePage vehicleEnginepage;

    public void selectCarEngineTest(WebDriver driver, String carEngine) {

        vehicleEnginepage = new VehicleEnginePage(driver, carEngine);

        vehicleEnginepage.verifyEnginePage();
        vehicleEnginepage.clickOnselectEngineBtn();

    }
}
