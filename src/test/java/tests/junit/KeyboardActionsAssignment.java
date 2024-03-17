package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;

public class KeyboardActionsAssignment extends Tests{

    @Test
    public void KeyboardActionsTest(){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("s").sendKeys("croll").sendKeys(Keys.SPACE)
                .sendKeys(Keys.SHIFT).sendKeys("m").sendKeys("ethods").sendKeys(Keys.ENTER).perform();

    }
    @BeforeEach
    public void BeforeEach(){
        driver.navigate().to("  https://www.google.com/");
    }
    @AfterEach
    public void AfterEach(){
        driver.quit();
    }
}


