package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment3week5 {
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
    public void testInvalidPassword() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username and incorrect password
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");

        // Click on login button
        driver.findElement(By.id("submit")).click();

        // Soft assert error message
        String errorMessage = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(errorMessage.contains("Your password is invalid!"), "Error message validation failed");


    }
}