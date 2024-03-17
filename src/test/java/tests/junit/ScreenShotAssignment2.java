package tests.junit;
import com.google.common.io.Files;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;


public class ScreenShotAssignment2 extends Tests{
    @Test
    public void takeScreenshot() throws IOException {
        // Go to amazon.com
        driver.get("https://www.amazon.com/");
        // save screenshot into specific file
        String screenshotPath = "C:/Users/LENOVO/Desktop/Screenshot/amazonScreenshot.png";
        String screenshotPath2 = "C:/Users/LENOVO/Desktop/Screenshot/amazonLogoScreenshot.png";
        // Take Full Page Screenshot.
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile, new File(screenshotPath ));
        // Take any specific WebElement ScreenShot
        WebElement logoScreenshot = driver.findElement((By.id("nav-logo-sprites")));
        File screenshotFile2 = logoScreenshot.getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile2, new File(screenshotPath2));
}
    @AfterEach
    public void AfterEach() {

        driver.quit();
    }
}
