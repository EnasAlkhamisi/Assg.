package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

//Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: “Opening a new window”
//Verify the title of the page is “The Internet”
//Click on the “Click Here” button
//Verify the new window title is “New Window”
//Go back to the previous window and then verify the title: “The Internet”

public class assignment1week4  extends test.junit.Test {
    @org.junit.jupiter.api.Test
    public void WindowHandlingExample() throws InterruptedException {

        // Navigate to the URL
        driver.get("https://the-internet.herokuapp.com/windows");
        // Verify the text "Opening a new window"
        WebElement textElement = driver.findElement(By.tagName("h3"));
        String text = textElement.getText();
        assert text.equals("Opening a new window") : "Text verification failed";
        // Verify the title of the page is "The Internet"
        String pageTitle = driver.getTitle();
        assert pageTitle.equals("The Internet") : "Page title verification failed";
        // Click on the "Click Here" button
        driver.findElement(By.linkText("Click Here")).click();
        // Switch to the new window
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Verify the new window title is "New Window"
        String newWindowTitle = driver.getTitle();
        assert newWindowTitle.equals("New Window") : "New window title verification failed";
        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Verify the title of the main window is "The Internet"
        String mainWindowTitle = driver.getTitle();
        assert mainWindowTitle.equals("The Internet") : "Main window title verification failed";

    }

}

