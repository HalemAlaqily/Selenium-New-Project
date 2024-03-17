package tests.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//https://demoqa.com/select-menu
//Get all the options of the dropdown
//Options size
//Print all test
//Verify the dropdown has option "Black"
//Print FirstSelectedOptionTes  t
//Select option "Yellow"
public class DropDownMenu {
    WebDriver driver;
    @Test
public void getDropDownOptions(){
        //By DropDownOptions = By.xpath("");
        WebElement dropdownOptions = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
        Select objSelect = new Select(dropdownOptions);
        //List list = new ArrayList();
        for (WebElement element: objSelect.getOptions()){
            System.out.println(element.getText());
        }

        //objSelect.selectByVisibleText();
        //List<WebElement> allOptions = objSelect.getOptions();
        //System.out.println(allOptions.size());
        //System.out.println(allOptions.get(2).getText());

    }

@Test
    public void checkIsBlackIn(){
    WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
    Select select = new Select(dropdown);
    WebElement option = select.getOptions().get(4);
    String optionText = option.getText();
    Assertions.assertEquals("Black", optionText);


    }


        @Test
public void verifyDropdownHasOptionBlack(){
        //By DropDownOptions = By.xpath("");
        WebElement dropdownOptions = driver.findElement(By.id("oldSelectMenu"));
        Select objSelect = new Select(dropdownOptions);
        //objSelect.selectByVisibleText("Green");
        List<WebElement> allOptions = objSelect.getOptions();
        System.out.println(allOptions.size());
        //System.out.println(allOptions.get(2).getText());

    }
    @BeforeEach
public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/select-menu");

    }
    @AfterEach
public void afterEach(){
        driver.quit();

    }
    private String getCartItemName(int cartItemNumber){
        By cartItemName = By.xpath("(//div[@class='inventory_item_name'])["+cartItemNumber+"]");
        return driver.findElement(cartItemName).getText();
    }
}
