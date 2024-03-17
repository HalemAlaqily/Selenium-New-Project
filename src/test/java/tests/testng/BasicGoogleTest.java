package tests.testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class BasicGoogleTest extends Tests{
    @Test
    public void quickGoogleSearch(){
        bot.navigate("https://www.google.com/");
        By SearchFiled = By.name("APjFqb");
        bot.type(SearchFiled,"selenium webdriver"+ Keys.RETURN);
        By result = By.id("result-stats");
        Assert.assertNotEquals("",driver.findElement(result).getText());

    }
}
