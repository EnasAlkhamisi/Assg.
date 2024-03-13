package junit;

import engine.ActionsBot;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
public class assignment2week4 extends test.junit.Test  {

    @Test
    public void DragAndDropExample () throws InterruptedException {


        // Open the URL
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Instantiate the Actions class
        Actions actions = new Actions(driver);

        // Locate the BANK button and the Account section in DEBIT SIDE
        WebElement bankButton = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement debitAccountSection = driver.findElement(By.xpath("//ol[@id='bank']/li"));

        // Perform the drag and drop action
        actions.dragAndDrop(bankButton, debitAccountSection).build().perform();

        // Locate the SALES button and the Account section in CREDIT SIDE
        WebElement salesButton = driver.findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement creditAccountSection = driver.findElement(By.xpath("//ol[@id='loan']/li"));

        // Perform the drag and drop action
        actions.dragAndDrop(salesButton, creditAccountSection).build().perform();

        // Locate the 5000 button and the Amount section in DEBIT SIDE
        WebElement debitAmountSection = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
        WebElement amount5000Button = driver.findElement(By.xpath("//*[@id=\"fourth\"]"));

        // Perform the drag and drop action
        actions.dragAndDrop(amount5000Button, debitAmountSection).build().perform();

        // Locate the second 5000 button and the Amount section in CREDIT SIDE
        WebElement creditAmountSection = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
        WebElement secondAmount5000Button = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

        // Perform the drag and drop action
        actions.dragAndDrop(secondAmount5000Button, creditAmountSection).build().perform();

        // Verify the visibility of the Perfect text
        WebElement perfectText = driver.findElement(By.xpath("//a[text()='Perfect!']"));
        assert perfectText.isDisplayed() : "Perfect text is not visible.";
        System.out.println("Perfect text is visible.");


    }
    }
