/*package testPackage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
 * login as standard_user
 * use Selenium Relative Locators to identify the login button


public class UserRelativesLocator {
    WebDriver driver;
    String standardUser = "standard_user";
    String unifiedPassword = "secret_sauce";

@Test



public void loginTask(){

    WebElement username = driver.findElement(By.id("user-name"));
    username.sendKeys("standard_user");
    WebElement password = driver.findElement(By.id("password"));
    username.sendKeys("secret_sauce");
    By button = UserRelativesLocator.this();
}
    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}*/