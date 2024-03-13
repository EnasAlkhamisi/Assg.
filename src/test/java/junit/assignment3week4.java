package junit;

import engine.ActionsBot;
import org.junit.jupiter.api.Test;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
public class assignment3week4 extends test.junit.Test {
    @Test
    public void GoogleSearchExample  () {

        // Navigate to Google
        driver.get("https://www.google.com/");
        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Create an instance of Actions
        Actions actions = new Actions(driver);

        // Perform keyboard actions
        actions.sendKeys(searchBox, "Scroll Methods")
                .sendKeys(Keys.RETURN)
                .build()
                .perform();



    }

}
