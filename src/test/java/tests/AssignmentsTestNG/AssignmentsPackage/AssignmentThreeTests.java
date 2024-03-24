package tests.AssignmentsTestNG.AssignmentsPackage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/

public class AssignmentThreeTests extends Tests{
    @Test(testName = "Basic Soft Assertions Test", description = "Given I am on the practice login page, When I input valid credentials, Then I am logged in successfully.")
    public void softAssertionsTest() {
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        By usernameInput = By.id("username");
        By passwordInput = By.id("password");
        By submitButton = By.id("submit");

        bot.type(usernameInput, ("student"));
        bot.type(passwordInput,("Password"));
        bot.click(submitButton);

        By logOutButton = By.xpath("//a[contains(@href,'practice-test-login')]");
        By faliarLoginLabel = By.id("error");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/", "Not redirected correctly!");
        softAssert.assertEquals(driver.findElement(faliarLoginLabel).getText(), "Your password is invalid!","Error message");
        softAssert.assertTrue(driver.findElement(faliarLoginLabel).isDisplayed(), "Your password is invalid!");
        softAssert.assertAll();
    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}

