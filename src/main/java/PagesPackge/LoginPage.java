package PagesPackge;
import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends FatherPage{

    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";
    By FirstName = By.id("input-firstname");
    By LastName = By.xpath("//input[@id='react-select-3-input']");
    By Email = By.id("input-email");
    By Telephone = By.id("input-telephone");
    By Password = By.id("input-password");
    By PasswordConfirm = By.id("input-confirm");
    By SubscribeRadioBtn = By.id("input-newsletter-no");
    By PrivacyPoliceBtn = By.xpath("//checkbox[@class='custom-control-input']");
    By loginBtn = By.xpath("//input[@value='Continue']");
    public LoginPage(WebDriver driver, ActionsBot bot) {
        super(driver,bot);
    }
    @Step("Go to lambdatest")
    public LoginPage goTo(){
        bot.navigate(url);
        return this;
    }
    @Step
    public LoginPage login(String firstName,
                             String lastName,
                             String email,
                             String telephone ,
                             String password,
                             String confirmPaswordass)
    {

        bot.type(FirstName, firstName);
        bot.type(LastName, lastName);
        bot.type(Email,email);
        bot.type(Telephone,telephone);
        bot.type(Password,password);
        bot.type(PasswordConfirm,confirmPaswordass);
        bot.click(SubscribeRadioBtn);
        bot.click(PrivacyPoliceBtn);
        bot.click(loginBtn);
        return new LoginPage(driver,bot);
    }

}
