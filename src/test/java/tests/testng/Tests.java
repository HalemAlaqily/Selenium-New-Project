package tests.testng;

import engine.ActionsBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.FilterReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
//import org.json.JSONObject;
public abstract class Tests {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;
    public ActionsBot bot;
    //protected static JSONobject testData;

    @BeforeClass
    public static void beforeAll(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
        //testData = (JSONobject) new JSONParser().parse(new FileReader("src/test/resources/testData/sample1.json", StandardCharsets.UTF_8) {
        }


    @BeforeMethod
    public void beforeEach(){
        logger.info("Opening Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @AfterMethod
    public void afterEach(){
        logger.info("Quitting Browser");
        driver.quit();
    }

}