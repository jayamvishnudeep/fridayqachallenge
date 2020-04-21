package friday.qa;

import friday.qa.base.TestBase;
import friday.qa.data.testData.CarDetails;
import friday.qa.data.testData.CarTestDataProvider;
import friday.qa.libraries.TakeScreenshot;
import friday.qa.testcases.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FridaySalesFunnelTest extends TestBase {

    PreConditionTest preConditionTest = new PreConditionTest();
    RegisteredOwnerTest registeredOwnerTest = new RegisteredOwnerTest();
    SelectVehicleTest selectVehicleTest = new SelectVehicleTest();
    VehicleModelTest vehicleModelTest = new VehicleModelTest();
    VehicleBodyTypeTest vehicleBodyTypeTest = new VehicleBodyTypeTest();
    VehicleFuelTypeTest vehicleFuelTypeTest = new VehicleFuelTypeTest();
    VehicleEnginePowerTest vehicleEnginePowerTest = new VehicleEnginePowerTest();
    VehicleEngineTest vehicleEngineTest = new VehicleEngineTest();
    VehicleRegistrationDateTest vehicleRegistrationDateTest = new VehicleRegistrationDateTest();
    BirthDetailsTest birthDetailsTest = new BirthDetailsTest();
    ShowHsnTsnCarTest showHsnTsnCarTest = new ShowHsnTsnCarTest();

    public FridaySalesFunnelTest() {

    }

    @BeforeMethod
    public void init() {
        initialization();
    }

    @Test(dataProvider = "car-data", dataProviderClass = CarTestDataProvider.class)
    public void shouldTestSalesFunnelBySelectingVehicleManually(CarDetails carData) {
        preConditionTest.fillPreConditionsTest(driver);
        registeredOwnerTest.fillRegisteredOwnerTest(driver);
        selectVehicleTest.selectUsingCarBrandTest(driver, carData.getBrand());
        vehicleModelTest.selectCarModelTest(driver, carData.getModel());
        if (!carData.getBodyType().isEmpty()) {
            vehicleBodyTypeTest.selectBodyTypeTest(driver, carData.getBodyType());
        }
        vehicleFuelTypeTest.selectFuelTypeTest(driver, carData.getFuel());
        if (!carData.getEnginePower().isEmpty()) {
            vehicleEnginePowerTest.selectCarEnginePowerTest(driver, carData.getEnginePower());
        }
        vehicleEngineTest.selectCarEngineTest(driver, carData.getCarEngine());
        vehicleRegistrationDateTest.enterVehicleRegistrationDateTest(driver);
        birthDetailsTest.verifyBirthDetailsUrl(driver);
    }

    @Test(dataProvider = "car-data", dataProviderClass = CarTestDataProvider.class)
    public void shouldTestSalesFunnelByUsingVehicleBrandSearchField(CarDetails carData) {
        preConditionTest.fillPreConditionsTest(driver);
        registeredOwnerTest.fillRegisteredOwnerTest(driver);
        selectVehicleTest.selectUsingCarBrandSearchTest(driver, carData.getBrand());
        vehicleModelTest.selectCarModelTest(driver, carData.getModel());
    }

    @Test(dataProvider = "car-hsn-tsn-data", dataProviderClass = CarTestDataProvider.class)
    public void shouldTestSalesFunnelBySelectingVehicleUsingHsnTsn(String hsn, String tsn, String expectedHsnTsnVehicleDetails) {
        preConditionTest.fillPreConditionsTest(driver);
        registeredOwnerTest.fillRegisteredOwnerTest(driver);
        selectVehicleTest.selectUsingHsnTsnTest(driver, hsn, tsn);
        showHsnTsnCarTest.verifyHsnTsnVehicleDetails(driver, expectedHsnTsnVehicleDetails);
        birthDetailsTest.verifyBirthDetailsUrl(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakeScreenshot.captureScreenshot(driver, result.getName());
        }

        driver.quit();
    }
}