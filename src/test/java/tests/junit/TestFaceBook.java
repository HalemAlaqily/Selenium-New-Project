package tests.junit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFaceBook {

    @Test
    public void testMethod(){
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.facebook.com/");

        String expectedUrl = "https://www.facebook.com/";

        String actualUrl = driver.getCurrentUrl();
        boolean urlMatch = expectedUrl.equals(actualUrl);
        System.out.println("Expected URL matches actual URL: " + urlMatch);
        String pageSource = driver.getPageSource();
        boolean containsFacebook = pageSource.contains("Facebook");
        System.out.println("Page source contains 'Facebook': " + containsFacebook);
        driver.close();
        driver.quit();

}}