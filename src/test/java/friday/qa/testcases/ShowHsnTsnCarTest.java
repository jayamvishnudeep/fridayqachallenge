package friday.qa.testcases;

import friday.qa.pages.ShowHsnTsnCarPage;
import org.openqa.selenium.WebDriver;

public class ShowHsnTsnCarTest {


    ShowHsnTsnCarPage showHsnTsnCarPage;

    public void verifyHsnTsnVehicleDetails(WebDriver driver, String expectedHsnTsnVehicleDetails) {

        showHsnTsnCarPage = new ShowHsnTsnCarPage(driver, expectedHsnTsnVehicleDetails);

        showHsnTsnCarPage.verifyShowHsnTsnPage();
        showHsnTsnCarPage.verifyHsnTsnVehicleDetails();
        showHsnTsnCarPage.clickOnShowHsnTsnConfirmationBtn();
    }
}
