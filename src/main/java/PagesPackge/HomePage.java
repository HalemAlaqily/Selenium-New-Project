package PagesPackge;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends FatherPage {
    private final String url = "https://ecommerce-playground.lambdatest.io/";
    private final By register= By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register'][@class='list-group-item']");

    public HomePage(WebDriver driver, ActionsBot bot)
    {
    super(driver,bot);
    }

    public HomePage goTo(){
        bot.navigate(url);
        return this;
    }
    public RegisterPage Register(){
        bot.click(register);
        return new RegisterPage(driver,bot);

    }
}
