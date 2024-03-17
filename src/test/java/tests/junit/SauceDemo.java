package tests.junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* navigate to this url https://www.saucedemo.com/v1/inventory.html
 * add the first item you find to your cart
 * open your cart*
 * assert that the item name is correct inside the cart
 */

public class SauceDemo {
    WebDriver driver;
    String loginPageUrl = "https://www.saucedemo.com/v1/index.html";
    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html";
    String standardUser = "standard_user";
    String unifiedPassword = "secret_sauce";


    @Test
    public void checkAddedCorrectly(){
        login("standard_user", "secret_sauce");
        addItemToCart(1);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Sauce Labs Backpack", getCartItemName(1));
    }

    private void addItemToCart(int itemNumber){
        By AddItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])["+itemNumber+"]");
        driver.findElement(AddItemToCartButton).click();
    }
    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    private String getCartItemName(int cartItemNumber){
        By cartItemName = By.xpath("(//div[@class='inventory_item_name'])["+cartItemNumber+"]");
        return driver.findElement(cartItemName).getText();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(loginPageUrl);
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
