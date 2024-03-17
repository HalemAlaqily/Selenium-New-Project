package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTestHero {
    WebDriver driver;

    @Test
    public void herokuapp(){
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

    }

    @Test
    public void testWebPages() {

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.linkText("Locators - Find By Playground Test Page")).click();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}

