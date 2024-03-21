package junit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
    */


    public class Assignment1week5 {
        protected WebDriver driver;
        protected Wait<WebDriver> wait;

        @Test
        public void testGoToFacebook() {
            driver.get("https://www.facebook.com");
        }

        @Test(dependsOnMethods = "testGoToFacebook")
        public void testGoToGoogle() {
            driver.get("https://www.google.com");
        }

        @Test(dependsOnMethods = "testGoToGoogle")
        public void testGoToAmazon() {
            driver.get("https://www.amazon.com");
        }

        @BeforeClass
        public void beforeClass() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        @AfterClass
        public void afterMethod() {
            driver.quit();
        }


    }
