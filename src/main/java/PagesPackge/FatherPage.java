package PagesPackge;
import engine.ActionsBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public  abstract class FatherPage {
    public final WebDriver driver;
    final ActionsBot bot;
    public FatherPage(WebDriver driver, ActionsBot bot){
        this.driver = driver;
        this.bot = bot;
    }
}