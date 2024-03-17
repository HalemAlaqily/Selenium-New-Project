package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


//Breakout task: 20 minutes
//navigate to: https://rangeslider.js.org/
//scroll to the right until you reach 700
//assert that the number says 700
public class breakoutSlider extends Tests {
    @Test
    public void Task01(){
        driver.navigate().to(" https://rangeslider.js.org/");
        WebElement rangeSlider = driver.findElement(By.id("js-rangeslider-0"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(rangeSlider)
                .moveByOffset(100, 0)
                .release()
                .perform();

        WebElement numberElement = driver.findElement(By.id("js-output"));
        String displayedNumber = numberElement.getText();
        Assertions.assertEquals("700",displayedNumber);



    }
}
