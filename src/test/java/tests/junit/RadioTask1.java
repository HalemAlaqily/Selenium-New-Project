package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//Task 1:
//Go to URL: https://demoqa.com/radio-button
//Verify whether all 3 options given to the question can be selected.
//When each option is selected, print the following texts on the console.


public class RadioTask1 {

    WebDriver driver;

    @Test
    public void test1(){
        By radioButtonyes = By.xpath("//*[@for='yesRadio']");
        driver.findElement(radioButtonyes).click();
        var isSelectedYes = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals("You have Selected Yes",isSelectedYes);

    }

    @Test
    public void test2(){

        By radioButtonImp = By.xpath("//*[@for='impressiveRadio']");
        driver.findElement(radioButtonImp).click();
        var isSelectedImp = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals("You have selected Impressive",isSelectedImp);
    }

    @Test
    public void test3(){

        By radioButtonNo = By.xpath("//*[@for='noRadio']");
        driver.findElement(radioButtonNo).click();
        var isSelectedNo = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();

    }


    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/radio-button");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
