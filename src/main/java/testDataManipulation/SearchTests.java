package testDataManipulation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests {
    WebDriver driver;

    @Test(dataProvider = "searchItems")
    public void test(String item){
        By emailInput = By.id("input-email");
        By passwordInput = By.id("input-password");
        By loginButton = By.xpath("//input[@value='Login']");
        driver.findElement(emailInput).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordInput).sendKeys("123456789");
        driver.findElement(loginButton).click();
        By searchInput = By.name("search");
        driver.findElement(searchInput).sendKeys(item+ Keys.ENTER);
        int searchResultsCount = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]")).size();
        System.out.println("Search results for " + item + ": " + searchResultsCount);
    }

    @DataProvider(name = "searchItems")
    public Object[][] searchItemsProvider() {
        return new Object[][]{{"Mac"}, {"iPad"}, {"Samsung"}};
    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/login");
    }
}
