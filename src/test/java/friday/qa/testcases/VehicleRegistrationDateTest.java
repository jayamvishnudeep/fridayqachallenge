package friday.qa.testcases;

import friday.qa.pages.VehicleRegistrationDatePage;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VehicleRegistrationDateTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yyyy");


    VehicleRegistrationDatePage vehicleRegistrationDatePage;

    public void enterVehicleRegistrationDateTest(WebDriver driver) {

        vehicleRegistrationDatePage = new VehicleRegistrationDatePage(driver);
        verifyRegistrationDateValidation();
        vehicleRegistrationDatePage.clearRegistrationDate();
        vehicleRegistrationDatePage.fillRegistrationDate("12.2017");
        vehicleRegistrationDatePage.verifyRegistrationDatePage();
        vehicleRegistrationDatePage.clickOnRegistrationDateSubmitBtn();

    }

    public void verifyRegistrationDateValidation() {
        // empty registration date validation
        vehicleRegistrationDatePage.clearRegistrationDate();
        vehicleRegistrationDatePage.verifyFirstRegistrationDateErrorInfo();

        // future registration date validation
        vehicleRegistrationDatePage.fillRegistrationDate(LocalDate.now().plusYears(2).format(formatter));
        vehicleRegistrationDatePage.verifyFirstRegistrationDateErrorInfo();

    }


}
