package tests.AssignmentsTestNG.AssignmentsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
public class AssignmentFourTests {
    WebDriver driver;
    //Login with that credentials
    @Test(dataProvider = "getSearchData")
    public void searchFunction(String searchQuery){
        loginFunction( "input-email", "input-password");
        By searchProduct = By.name("search");
        driver.findElement(searchProduct).sendKeys(searchQuery+ Keys.RETURN);
        int AmountOfProduct = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]")).size();
        System.out.println("Product Amount of " + searchQuery +"is" + AmountOfProduct);
    }
    @DataProvider(name = "getSearchData")
    public Object[][] dataProvider() {

        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
    public void loginFunction( String username, String password){
        By userName = By.id("input-email");
        By password1 = By.id("input-password");
        By loginButton = By.xpath("//input[@value='Login']");
        driver.findElement(userName).sendKeys("clarusway@gmail.com");
        driver.findElement(password1).sendKeys("123456789");
        driver.findElement(loginButton).click();
    }



    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to URL: http://opencart.abstracta.us/index.php?route=account/login
        driver.navigate().to("http://opencart.abstracta.us/index.php?route=account/login");

    }
    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        driver.quit();
    }
}
