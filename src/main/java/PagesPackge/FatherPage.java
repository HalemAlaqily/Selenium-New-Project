package PagesPackge;
import engine.ActionsBot;
import org.openqa.selenium.WebDriver;

public  abstract class FatherPage {
    public final WebDriver driver;
    final ActionsBot bot;
    public FatherPage(WebDriver driver, ActionsBot bot){
        this.driver = driver;
        this.bot = bot;
    }
}