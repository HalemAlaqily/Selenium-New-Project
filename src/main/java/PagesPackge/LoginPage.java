package PagesPackge;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends FatherPage {
    private final By login = By.xpath("//a[@href=' https://ecommerce-playground.lambdatest.io/index.php?route=account/account/home][@class='list-group-item']");
    private final By emailInput = By.id("input-email");
    private final By passwordInput = By.id("input-password");
    private final By submitButton = By.xpath("//input[@class='btn btn-primary']");

    public LoginPage(WebDriver driver, ActionsBot bot) {

        super(driver,bot);
    }

    private void login(String username, String password){
        bot.type(emailInput, username);
        bot.type(passwordInput, password);
        bot.click(submitButton);
    }

}
