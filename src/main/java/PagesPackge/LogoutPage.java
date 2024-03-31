package PagesPackge;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutPage extends FatherPage {
    private final By login = By.xpath("//a[@href=' https://ecommerce-playground.lambdatest.io/index.php?route=account/account/login][@class='list-group-item']");

    public LogoutPage(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    public LoginPage logoutBtn() {
        bot.click(login);
        return new LoginPage(driver,bot);
    }
}
