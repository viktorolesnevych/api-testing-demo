package stepDefs;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Utils.APIUtils;
import pageObjects.UpdateUserPage;
import POJOs.User;

public class MyStepdefs {

    private WebDriver driver;
    private APIUtils API_;
    private UpdateUserPage objUserPage;
    private User myUser;
    private int userId;

    final String DRIVER_PATH = "/Users/viktormacbook/Documents/Selenium/chromedriver";
    final String USERS_ENDPOINT = "https://selenium-spring2020.000webhostapp.com/api/v1/users";
    final String GET_USER_ENDPOINT = "https://selenium-spring2020.000webhostapp.com/web/index.php?r=users%2Fupdate&id=";

    @Before
    public void initialiseMainElements(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        objUserPage = new UpdateUserPage(driver);
        API_= new APIUtils();
        myUser = new User("name99", "username99", "+3423456432", "name99@gmail.com", "9999 W Michigan St");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("^New user is created via API$")
    public void newUserIsCreatedViaAPI() throws UnirestException {
        HttpResponse<JsonNode> response = API_.post_API(USERS_ENDPOINT,myUser);
        JSONObject userJsonObject = response.getBody().getObject();
        userId = (int)(userJsonObject.get("id"));
    }

    @When("^User navigates to page to update the created user$")
    public void userNavigatesToPageToUpdateTheCreatedUser() throws InterruptedException {
        driver.get(GET_USER_ENDPOINT + userId);
    }

    @And("^User types new personal data of choosed user$")
    public void userTypesNewPersonalDataOfChoosedUser() throws InterruptedException {
        myUser = new User("updatedName", "updatedUsername", "updatedPhone", "updatedEmail", "updatedAddress");
        objUserPage.updateUser(myUser);
    }

    @Then("^User checks if data is correct$")
    public void userChecksIfDataIsCorrect() {
        System.out.println(objUserPage.getId() + " " + objUserPage.getName());
        Assert.assertEquals(objUserPage.getId(), Integer.toString(userId));
        Assert.assertEquals(objUserPage.getName(), myUser.name);
        Assert.assertEquals(objUserPage.getUsername(), myUser.username);
        Assert.assertEquals(objUserPage.getEmail(), myUser.email);
        Assert.assertEquals(objUserPage.getPhone(), myUser.phone);
        Assert.assertEquals(objUserPage.getAddress(), myUser.address);
        objUserPage.clickUpdate();
    }
}
