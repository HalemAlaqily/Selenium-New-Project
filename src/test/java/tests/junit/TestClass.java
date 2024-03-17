package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
    @Test
    public void testMethod(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        System.out.println();
        driver.getTitle();
        driver.close();
        driver.quit();

    }
}
