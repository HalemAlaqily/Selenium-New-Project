package tests.AssignmentsTestNG.AssignmentsPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
public class AssignmentFiveTests {
    WebDriver driver;
@Test//a[@href ='/docs/configuration']"
public void toDoAppTest(){
    //Click to To-Do App
    driver.findElement(By.xpath("//a[@href='todo-app.html']")).click();
    //Checking Box to do-4 and Checking Box to do-5
    WebElement check4=driver.findElement(By.name("todo-4"));
    WebElement check5=driver.findElement(By.name("todo-5"));
    check4.click();
    check5.click();


    //If both clicks worked, then the following List should be have length 2.
    By checkedList = By.xpath("//span[@class='done-true']");
    int liSize1 = driver.findElements(checkedList ).size();
    System.out.println(liSize1);

    //Assert that this is correct
    Assert.assertTrue(liSize1 == 2);

    //Assert that the to do we added is present in the list
    List<WebElement> toDoList = new ArrayList<>();

    // Add to-do item 4
    toDoList.add(check4);

    // Add to-do item 5
    toDoList.add(check5);

    By newToDo = By.id("todotext");
    driver.findElement(newToDo).sendKeys("New To Do Checkbox");
    By add = By.id("addbutton");
    driver.findElement(add).click();
    WebElement myNewToDo=driver.findElement(By.xpath("//span[@class='done-false']"));
    myNewToDo.click();
    toDoList.add(myNewToDo);

    //Archiving old todos
    driver.findElement(By.xpath("//a[text()='archive']")).click();

    //If our archive link worked, then the following list should have length 4.
    By nonCheckedList = By.xpath("//span[@class='done-false']");
    int liSize2 = driver.findElements(nonCheckedList).size();
    System.out.println(liSize2);

    //Assert that this is true as well
    Assert.assertTrue(liSize2 == 4);

    //Doing Cross Browser Testing.




}
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Go to URL: http://crossbrowsertesting.github.io/
        driver.navigate().to("http://crossbrowsertesting.github.io/");

    }
    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        driver.quit();
    }

}
