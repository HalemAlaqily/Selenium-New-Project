package tests.junit;


import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxOptions;



/**
 * Use Google Chrome
 * Navigate to <a href="https://www.google.com/">Google.com</a>
 * Search for "Selenium"
 * Check that results stats is not empty
 * Change to using Firefox
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.Wait;


public class SyncTest {
    Wait<WebDriver> wait;
    WebDriver driver;
    @BeforeEach
    public void beforeeach(){
        FirefoxOptions firefox = new FirefoxOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }
    @AfterEach
    public void aftereach(){
        driver.quit();

    }


    //@Test
    public void googleSync() throws InterruptedException {
        By searchBox = By.id("APJFqb");
        driver.findElement(searchBox).sendKeys("selenium"+ Keys.RETURN);
//Thread.sleep(5000);
        /*wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(100))
                .ignoring(NoSuchElementException.class);*/

    }

}
