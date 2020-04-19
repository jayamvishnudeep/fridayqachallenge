package friday.qa.data;

import friday.qa.pojo.CarDetails;
import org.testng.annotations.DataProvider;

public class CarTestDataProvider {


    @DataProvider(name = "car-data")
    public Object[][] getCarTestData() {
        return new Object[][]{
                {new CarDetails("VW", "Caddy", "Kasten", "96 kW / 131 PS", "CADDY 1.4", "Benzin")},
                {new CarDetails("FORD", "Fiesta", "", "40 kW / 54 PS", "FIESTA", "Benzin")},
                {new CarDetails("AUDI", "A6", "Kombi", "96 kW / 131 PS", "A6 AVANT 1.9 TDI", "Diesel")},
                {new CarDetails("HYUNDAI", "Elantra", "", "", "ELANTRA 2.0 CRDI STH", "Diesel")},
        };
    }

    @DataProvider(name = "car-hsn-tsn-data")
    public Object[][] getCarHsnTsn() {
        return new Object[][]{
                {"0035", "BCM", "OPEL CORSA-E 1.4 LPG 3T, Limousine, Gas, 1398 cc, 66/90 KW/PS"},
                {"0588", "BBA", "AUDI A5 SPORTBACK 1.8 TFSI, Coupe, Benzin, 1798 cc, 106/144 KW/PS"}
        };
    }

}
