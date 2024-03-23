package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
public class assignment5week5 extends junit.Test {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

        @Test
        public void testToDoApp() {

            //Go to URL: http://crossbrowsertesting.github.io/
            driver.get("http://crossbrowsertesting.github.io/");
            //Click to To-Do App
            driver.findElement(By.linkText("To-Do App")).click();
            //Checking Box to do-4 and Checking Box to do-5
            WebElement todo4 = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[4]/input"));
            WebElement todo5 = driver.findElement(By.xpath("/html/body/div[1]/div/div/ul/li[5]/input"));
            todo4.click();
            todo5.click();
            //If both clicks worked, then the following List should be have length 2.
            //Assert that this is correct
            Assert.assertEquals(driver.findElements(By.cssSelector(".done-true")).size(), 2, "The to-do list should have a length of 2.");
            //Assert that the to do we added is present in the list
            By todoInput = By.id("todotext");
            driver.findElement(todoInput).sendKeys("Complete Assignments" + Keys.ENTER);
            Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='done-false'])[4]")).isDisplayed());
            //Archiving old todos
            driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
            //If our archive link worked, then the following list should have length 4.
            // Assert that this is true as well
            Assert.assertEquals(driver.findElements(By.cssSelector(".done-false")).size(), 4, "The to-do list should have a length of 4 after archiving.");
        }


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterClass
    public void afterMethod() {
    //    driver.quit();
    }


}
