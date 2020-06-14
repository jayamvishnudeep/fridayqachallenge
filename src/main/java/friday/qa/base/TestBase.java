package friday.qa.base;

import friday.qa.data.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public static Properties prop;
    public static Logger logger = LogManager.getLogger("TestBase");


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/friday/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialization() throws Exception {
        String browserName = prop.getProperty("browserName");

        //Check if parameter passed as 'chrome'

        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverPath"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            logger.info("Chrome Launched !!!");

        }

        //Check if parameter passed as 'firefox'

        else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverPath"));
            driver = new FirefoxDriver();
            logger.info("Firefox Launched !!!");

        }

        //Check if parameter passed as 'Safari'

        else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
            logger.info("Safari Launched !!!");

        }

        //Check if parameter passed as 'Edge'

        else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriverPath"));
            driver = new EdgeDriver();
            logger.info("Edge Launched !!!");

        } else {

            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
        logger.info("Navigated to : " + prop.getProperty("url"));
    }
}

