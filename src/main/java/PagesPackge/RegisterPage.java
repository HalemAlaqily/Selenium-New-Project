package PagesPackge;
import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends FatherPage{
    private final By logout = By.xpath("//a[@href=' https://ecommerce-playground.lambdatest.io/index.php?route=account/account/logout][@class='list-group-item']");
    By FirstName = By.id("input-firstname");
    By LastName = By.id("input-lastname");
    By Email = By.id("input-email");
    By Telephone = By.id("input-telephone");
    By Password = By.id("input-password");
    By PasswordConfirm = By.id("input-confirm");
    By SubscribeRadioBtn = By.id("input-newsletter-no");
    By PrivacyPoliceBtn = By.xpath("//checkbox[@class='custom-control-input']");
    By loginBtn = By.xpath("//input[@value='Continue']");
    public RegisterPage(WebDriver driver, ActionsBot bot) {
        super(driver,bot);
    }
    @Step
    public LogoutPage register (String firstName,
                                  String lastName,
                                  String email,
                                  String telephone ,
                                  String password,
                                  String confirmPassword)
    {

        bot.type(FirstName, firstName);
        bot.type(LastName, lastName);
        bot.type(Email,email);
        bot.type(Telephone,telephone);
        bot.type(Password,password);
        bot.type(PasswordConfirm,confirmPassword);
        bot.click(SubscribeRadioBtn);
        bot.click(PrivacyPoliceBtn);
        bot.click(loginBtn);
        return new LogoutPage(driver,bot);
    }
    /*public LogoutPage logout(){
        bot.click(logout);
        return new LogoutPage(driver,bot);

    }*/
}
