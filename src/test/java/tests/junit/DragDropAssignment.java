package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class DragDropAssignment extends Tests{

    @Test
    public void DragDropTest(){
        Actions builder = new Actions(driver);
        //WebElement ButtonToAssert = driver.findElement(By.id("//a[@class='button button-green']"));

        WebElement BankToDrag = driver.findElement(By.id("credit2"));
        WebElement SalesToDrag = driver.findElement(By.id("credit1"));
        WebElement AccountINDrop = driver.findElement(By.id("ShoppingCart1"));
        WebElement Amount5000OneToDrag = driver.findElement(By.cssSelector("[data-id='2']"));
        WebElement Amount5000TwoToDrag = driver.findElement(By.cssSelector("[data-id='2']"));
        WebElement AmountToDrop = driver.findElement(By.id("shoppingCart4"));
        //Perform drag and drop
        builder.clickAndHold(BankToDrag)
                .pause(Duration.ofMillis(500))
                .dragAndDrop(BankToDrag, AccountINDrop).perform();
        builder.dragAndDrop(SalesToDrag, AccountINDrop).perform();
        builder.dragAndDrop(Amount5000OneToDrag, AmountToDrop).perform();
        builder.dragAndDrop(Amount5000TwoToDrag, AmountToDrop).perform();


        //Assertions.assertEquals("Perfect!", (ButtonToAssert).getText());

}
    @BeforeEach
    public void BeforeEach(){
        driver.navigate().to(" http://demo.guru99.com/test/drag_drop.html");
    }
    @AfterEach
    public void AfterEach(){
        driver.quit();
    }
}
