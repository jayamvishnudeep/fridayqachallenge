package friday.qa.testcases;

import friday.qa.pages.PreConditionPage;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PreConditionTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    PreConditionPage preConditionPage;

    public void fillPreConditionsTest(WebDriver driver) {

        preConditionPage = new PreConditionPage(driver);
        preConditionPage.clickOnAcceptCookiesBtn();
        preConditionPage.clickOnChangeInsurerBtn();
        preConditionPage.clickOnPurchaseOrOwnerChangeBtn();
        preConditionPage.validateFirstHelpText();
        preConditionPage.validateSecondHelpText();
        verifyInceptionDateValidationTest();
        preConditionPage.clearInceptionDate();
        preConditionPage.fillInceptionDate(LocalDate.now().plusDays(5).format(formatter));
        preConditionPage.clickOnPreConditionsSubmitBtn();

    }

    public void verifyInceptionDateValidationTest() {
        // empty inception date validation
        preConditionPage.clearInceptionDate();
        preConditionPage.verifyInceptionDateErrorInfo("Erforderlich");

        // past inception date validation
        preConditionPage.fillInceptionDate(LocalDate.now().minusDays(5).format(formatter));
        preConditionPage.verifyInceptionDateErrorInfo("Hups! Dieses Datum liegt in der Vergangenheit. Bitte überprüfe deine Eingabe.");

        // future inception date validation
        preConditionPage.clearInceptionDate();
        preConditionPage.fillInceptionDate(LocalDate.now().plusYears(1).format(formatter));
        preConditionPage.verifyInceptionDateErrorInfo("Hups! Dieses Datum liegt zu weit in der Zukunft. Bitte überprüfe deine Eingabe.");

    }
}
