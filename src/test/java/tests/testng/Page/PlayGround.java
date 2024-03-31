package tests.testng.Page;
import PagesPackge.HomePage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class PlayGround extends Tests {
    @Test
    public void PlayTest(){
        JSONObject testCaseData = (JSONObject) testData.get("Playground");
        String firstName = (String)testCaseData.get("firstName");
        String lastName = (String)testCaseData.get("lastName");
        String email = (String)testCaseData.get("email");
        String telephone = (String)testCaseData.get("telephone");
        String password = (String)testCaseData.get("password");
        String confirmPassword = (String)testCaseData.get("confirmPassword");
        new HomePage(driver,bot).goTo().Register().register(firstName,
                lastName,email,telephone, password,confirmPassword).logoutBtn();

    }
}
