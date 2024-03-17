/*package testPackage;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.asserts.Assertion;

/**
 * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
 * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"

public class w3sTask {
    WebDriver driver;

    public void locating(){

        By Maria = RelativeLocator.with(By.tagName("td")).toLeftOf(By.xpath("password"));
        String name = driver.findElement(cell).getText();
        Assertions.assertEquals("Maria Anders", name);







    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }


}*/
