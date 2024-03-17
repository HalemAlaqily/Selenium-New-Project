package tests.junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Navigate to website  https://testpages.herokuapp.com/styled/index.html
Under the Examples
Click on Locators - Find By Playground Test Page
Print the URL
Navigate back
Print the URL
Click on WebDriver Example Page
Print the URL
Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
And then verify ‘two, zero’ message is displayed on page
Close driver.
*/
public class TestTasks {
    WebDriver driver;
    String Playground = "findbytest";

    @Test

    public void testTaskSolve1(){
        driver.findElement(By.id("findbytest")).click();
        var currentUrl= driver.getCurrentUrl();
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Navigate back
        driver.navigate().back();

        // Print the URL
        System.out.println("Current URL after navigating back: " + driver.getCurrentUrl());


    }
    @Test

    public void writeInput1(){
        // writing text
        driver.findElement(By.id("webdriverexamplepage")).click();
        System.out.println("Current URL after navigating back: " + driver.getCurrentUrl());

    driver.findElement(By.id("numentry")).sendKeys("20");
        driver.findElement(By.id("submit-to-server")).click();

        By textInput = By.id("message");
        String Msg = driver.findElement(textInput).getText();
        Assertions.assertEquals(textInput,Msg);
    }


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
