package friday.qa.testcases;

import friday.qa.pages.VehicleBodyTypePage;
import org.openqa.selenium.WebDriver;

public class VehicleBodyTypeTest {
    VehicleBodyTypePage vehicleBodyTypePage;

    public void selectBodyTypeTest(WebDriver driver, String body) {

        vehicleBodyTypePage = new VehicleBodyTypePage(driver, body);
        vehicleBodyTypePage.verifyBodyTypePage();
        vehicleBodyTypePage.clickOnselectBodyTypeBtn();
    }
}
