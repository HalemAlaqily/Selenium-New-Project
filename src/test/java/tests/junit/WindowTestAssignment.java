package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowTestAssignment extends Tests{


    @Test
    public void windowHandling(){
    driver.navigate().to("https://the-internet.herokuapp.com/windows");
        String title = driver. getTitle();
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedText, actualText);

        // Verify the title of the page is "The Internet"
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Click on the "Click Here" button
        driver.findElement(By.linkText("Click Here")).click();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        String mainWindowHandle = driver.getWindowHandle();
        String newWindowHandle = getNewWindowHandle(windowHandles, mainWindowHandle);
        driver.switchTo().window(newWindowHandle);

        // Verify the new window title is "New Window"
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

        // Switch back to the previous window
        driver.switchTo().window(mainWindowHandle);

        // Verify the title of the previous window is "The Internet"
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);


    }

    private String getNewWindowHandle(Set<String> windowHandles, String mainWindowHandle) {
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                return handle;
            }
        }
        throw new IllegalStateException("New window handle not found");
    }
    @BeforeEach
    public void BeforeEach (){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
    }

    @AfterEach
    public void AfterEach (){
        // Close the WebDriver
        driver.quit();
    }
    }

