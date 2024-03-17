package tests.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on Locators - Find By Playground Test Page
        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();

        // Print the URL
        System.out.println(driver.getCurrentUrl());

        // Navigate back
        driver.navigate().back();

        // Print the URL
        System.out.println(driver.getCurrentUrl());

        // Click on WebDriver Example Page
        driver.findElement(By.linkText("WebDriver Example Page")).click();

        // Print the URL
        System.out.println(driver.getCurrentUrl());

        // Enter value -> 20 to "Enter Some Numbers inputBox"
        driver.findElement(By.id("numbers")).sendKeys("20");
        driver.findElement(By.id("numbers")).submit();

        // Verify 'two, zero' message is displayed on page
        String message = driver.findElement(By.id("number-message")).getText();
        if (message.equals("two, zero")) {
            System.out.println("Verification Passed: 'two, zero' message is displayed.");
        } else {
            System.out.println("Verification Failed: 'two, zero' message is not displayed.");
        }

        // Close driver
        driver.quit();
    }

}