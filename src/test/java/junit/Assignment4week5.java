package junit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment4week5 {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
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

    @Test
    public void Login(){

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();



    }

    @Test(dataProvider = "searchTerms")
    public void testSearch(String searchTerm) {
        performSearch(searchTerm);

    }

    private void performSearch(String searchTerm) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
        driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
    }

    @DataProvider(name = "searchTerms")
    public Object[] getSearchTerms() {
        return new Object[]{"Mac", "iPad", "Samsung"};
    }

    }