package tests.junit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

/**
 * Breakout task: 15 minutes
 * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
 * print the total number of cookies
 * add a new "fruit=apple" cookie
 * edit the "protein" cookie to have the value "meat"
 * delete the "vegetable" cookie
 * print all cookies
 * delete all cookies
 */
public class CookiesTest extends Tests{
    @Test
    public void  cookiesTest1(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        var cookies1 = driver.manage().getCookies();
        System.out.println(cookies1.size());
        cookies1.forEach(System.out:: println);
        driver.manage().addCookie(new Cookie("fruit","apple"));
        driver.manage().addCookie(new Cookie("beverage","milk"));
        cookies1 = driver.manage().getCookies();
        System.out.println("List Updated");
        cookies1.forEach(System.out:: println);
        driver.manage().deleteCookieNamed("protein");
        driver.manage().addCookie(new Cookie("protein","meat"));
        driver.manage().deleteCookieNamed("vegetable");
        driver.manage().deleteAllCookies();
        cookies1.forEach(System.out:: println);




    }
}
