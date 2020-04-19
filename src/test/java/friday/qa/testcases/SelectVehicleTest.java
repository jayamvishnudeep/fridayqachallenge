package friday.qa.testcases;

import friday.qa.pages.SelectVehiclePage;
import org.openqa.selenium.WebDriver;

public class SelectVehicleTest {
    SelectVehiclePage selectVehiclePage;

    public void selectUsingCarBrandTest(WebDriver driver, String brandName) {

        selectVehiclePage = new SelectVehiclePage(driver, brandName);

        selectVehiclePage.verifySelectVehiclePage();
        selectVehiclePage.clickOnselectBrandBtn();
    }

    public void selectUsingCarBrandSearchTest(WebDriver driver, String brandName) {

        selectVehiclePage = new SelectVehiclePage(driver, brandName);
        selectVehiclePage.fillVehicleBrandFilter(brandName);
        selectVehiclePage.verifySelectVehiclePage();
        selectVehiclePage.clickOnselectBrandBtn();
    }

    public void selectUsingHsnTsnTest(WebDriver driver, String hsn, String tsn) {

        selectVehiclePage = new SelectVehiclePage(driver, hsn, tsn, "04.2016" );

        selectVehiclePage.verifySelectVehiclePage();
        selectVehiclePage.clickOnHsnTsnBtnBtn();
        selectVehiclePage.fillFirstRegistrationDate();
        selectVehiclePage.fillHsn();
        selectVehiclePage.fillTsn();
        selectVehiclePage.clickOnHsnTsnSubmitBtn();
    }

}