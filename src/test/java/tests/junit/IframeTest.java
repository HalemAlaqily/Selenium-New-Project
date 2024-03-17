package tests.junit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeTest {

    WebDriver driver;
    @Test
    public void framreTest(){

    }
    @Test
public void IframreTest(){

            driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
            WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));

            driver.switchTo().frame(iframe);

            var txt = driver.findElement(By.tagName("h1")).getText();
            Assertions.assertEquals("Testing Clicks", txt);
            driver.switchTo().defaultContent();



}
@BeforeEach
public void BeforeEach(){


}

@AfterEach
    public void AfterEach(){
        driver.quit();

}

}
