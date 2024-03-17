package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//Go to URL: http://demo.automationtesting.in/Alerts.html
//Click "Alert with OK" and click 'click the button to display an alert box:’
//Accept Alert(I am an alert box!) and print alert on console.
//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
//Cancel Alert (Press a Button !)
//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
//And then sendKeys «Bootcamp» (Please enter your name)
//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.


public class AlertTestTasks {


         WebDriver driver;

        @BeforeEach
        public void BeforeEach() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
            driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        }

        @Test
        public void testAlertOK() {

            driver.findElement(By.xpath("//a[@href='#OKTab']")).click();
            driver.findElement(By.xpath("//Button[@class='btn btn-danger']")).click();

            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            System.out.println("Alert Message: " + alertMessage);
            alert.accept();
        }

        @Test
        public void testAlertsWithOKAndCancel() {

            driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
            driver.findElement(By.xpath("//Button[@class='btn btn-primary']")).click();

            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }

        @Test
        public void testAlertsWithTextbox() {

            driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
            driver.findElement(By.xpath("//Button[@class='btn btn-info']")).click();
            Alert alert = driver.switchTo().alert();

            alert.sendKeys("«Bootcamp» Halema Mohammed Alaqily");
            alert.accept();
            String alertResponse = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
            System.out.println(alertResponse);
            Assertions.assertEquals("Hello «Bootcamp» Halema Mohammed Alaqily How are you today",alertResponse);
            String message = "Hello Bootcamp How are you today";
            System.out.println(message);
        }

        @AfterEach
        public void AfterEach() {
            driver.quit();
        }
}
