package tests.Excel.AssignmentsPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
  Create tests that depend on each other
  Create beforeClass and set up settings.
  By creating interdependent tests;
  First go to Facebook.
  Then go to Google depending on Facebook,
  Then go to Amazon depending on Google
  Close the driver.
   */



    public class AssignmentOne extends Tests
    {
        WebDriver driver;
        @Test
        public void FacebookTest(){

            driver.navigate().to("https://www.Facebook.com/");
        }
        @Test(dependsOnMethods = "Facebook")
        public void GoogleTest(){

            driver.navigate().to("https://www.google.com/");
        }
        @Test(dependsOnMethods = "Google")
        public void AmazonTest(){

            driver.navigate().to("https://www.amazon.com/");
        }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}
