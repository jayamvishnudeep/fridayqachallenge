package friday.qa.testcases;

import friday.qa.pages.BirthDetailsPage;
import org.openqa.selenium.WebDriver;


public class BirthDetailsTest {

    BirthDetailsPage birthDetailspage;

    public void verifyBirthDetailsUrl(WebDriver driver) {

        birthDetailspage = new BirthDetailsPage(driver);

        birthDetailspage.verifyBirthDetailsPage();

    }
}