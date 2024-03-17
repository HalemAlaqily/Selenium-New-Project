package tests.testng;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SoftAssertion extends Tests{
    @Test
    public void softAssertionTest(){
        bot.navigate("");
        By usernameInput = null;
        By passwordInput = null;
        By submitButton = null;
        bot.type(usernameInput,"");
        bot.type(passwordInput,"");
        bot.click(submitButton);


    }
}
