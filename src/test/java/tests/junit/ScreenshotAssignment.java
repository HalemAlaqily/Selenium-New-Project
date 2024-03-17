package tests.junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class ScreenshotAssignment extends Tests{


    @Test
    public void takeScreenshot() throws IOException {
        // Navigate to Amazon.com
        driver.get("https://www.amazon.com/");

        // Wait for the page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify the destination file path
        String screenshotPath = "C:/screenshots/amazon_screenshot.png";
        File destination = new File(screenshotPath);

        // Create the parent directory if it doesn't exist
        Path parentDir = destination.getParentFile().toPath();
        Files.createDirectories(parentDir);

        // Copy the screenshot file to the destination location
        Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot saved to: " + screenshotPath);
    }

    @AfterEach
    public void AfterEach() {

        driver.quit();
    }
}