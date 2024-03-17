package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class CookiesAssignment extends Tests{
    /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
   */
    @Test
    public void CookiesTest(){
        // Print initial size and list of cookies
        System.out.println("Initial size: " + driver.manage().getCookies().size());
        System.out.println("Initial list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);

        // Add a new cookie
        driver.manage().addCookie(new Cookie("datr", "Strictly necessary cookies"));
        driver.manage().addCookie(new Cookie("fr", "Session ID"));
        driver.manage().addCookie(new Cookie("wd", "Preference cookies"));
        driver.manage().addCookie(new Cookie("sb", "Marketing Cookies"));


        // Delete a cookie by name
        driver.manage().deleteCookieNamed("datr");
        driver.manage().deleteCookieNamed("sb");


        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Verify that all cookies are deleted
     Assertions.assertEquals(0, driver.manage().getCookies().size());
    }
    @BeforeEach
    public void BeforeEach(){
        driver.navigate().to("http://facebook.com");
    }
    @AfterEach
    public void AfterEach(){
        driver.quit();
    }
}
