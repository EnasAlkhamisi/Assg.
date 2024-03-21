package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/*
   Go to Amazon https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
public class assignment4week4  extends junit.Test {
    @Test
    public void AmazonDemoTest  () throws InterruptedException {


        // Navigate to the Amazon Demo Test page
        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

        // Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");



        // Find any element on the page to give it focus
        WebElement backToTopText = driver.findElement(By.linkText("Back to top"));

        // Use Actions class to simulate pressing the Up key
        Actions actions = new Actions(driver);
        actions.sendKeys(backToTopText, Keys.UP).perform();
        // Click on the "Back to top" web element
        backToTopText.click();

        // Click on the Amazon logo at the bottom of the page using JavascriptExecutor
        WebElement amazonLogoElement = driver.findElement(By.id("nav-logo-sprites"));
        js.executeScript("arguments[0].click();", amazonLogoElement);


        // Use Actions to type "ClarusWay" in the search box and perform the search
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(searchBoxElement, "ClarusWay").sendKeys(Keys.ENTER).build().perform();


    }


}
