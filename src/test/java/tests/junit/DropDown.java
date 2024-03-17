package tests.junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    WebDriver driver;

    @Test
    public void dropDown1(){
        By dr1 = By.id("dropdown");
        Select select = new Select(driver.findElement(dr1));
        select.selectByValue("1");
        boolean isSelected = driver.findElement(dr1).isDisplayed();
        select.selectByValue("2");
        isSelected = driver.findElement(dr1).isSelected();
        System.out.println(select.getFirstSelectedOption().getText());

        //List<WebElement> allOptions = select.getOptions();
        //System.out.println(allOptions.get(2).getText());


    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}