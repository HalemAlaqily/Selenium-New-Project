package tests.junit;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
public class DropDownMenuTest {
    WebDriver driver;

    @Test
    public void testDropdown() {
        WebElement dropdownOptions = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
        Select objSelect = new Select(dropdownOptions);
        List<String> dropdownValues = new ArrayList<>();

        for (WebElement element : objSelect.getOptions()) {
            String dropDownColors = element.getText();
            dropdownValues.add(dropDownColors);
        }

        int optionsSize = dropdownValues.size();
        System.out.println(optionsSize);
        //Assertions.assertEquals(optionsSize, dropdownValues.size());

        for (String value : dropdownValues) {
            System.out.println(value);
        }
        boolean hasOptionBlack = dropdownValues.contains("Black");
        Assertions.assertTrue(hasOptionBlack);

        objSelect.selectByVisibleText("Yellow");
        WebElement firstSelectedOption = objSelect.getFirstSelectedOption();
        System.out.println("First Selected Option: " + firstSelectedOption.getText());



    }
@BeforeEach
public void BeforeEach(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("start-maximized");
    driver = new ChromeDriver(chromeOptions);
    driver.navigate().to("https://demoqa.com/select-menu");
}
    @AfterEach
    public void AfterEach(){
        driver.quit();
    }

}
