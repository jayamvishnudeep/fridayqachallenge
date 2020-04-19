package friday.qa.testcases;

import friday.qa.pages.VehicleModelPage;
import org.openqa.selenium.WebDriver;

public class VehicleModelTest {

    VehicleModelPage vehicleModelpage;

    public void selectCarModelTest(WebDriver driver, String model) {

        vehicleModelpage = new VehicleModelPage(driver, model);

        vehicleModelpage.verifyModelPage();
        vehicleModelpage.clickOnselectModelBtn();

    }
}