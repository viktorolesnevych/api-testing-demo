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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CommandsAPI;
import plainOldJavaObjects.User;

public class MyStepdefs {

    private WebDriver driver;
    private CommandsAPI cmd_API;
    private User myUser;

    final String DRIVER_PATH = "/Users/viktormacbook/Documents/Selenium/chromedriver";
    final String USERS_ENDPOINT = "https://selenium-spring2020.000webhostapp.com/api/v1/users";
    final String GET_USER_ENDPOINT = "https://selenium-spring2020.000webhostapp.com/web/index.php?r=users%2Fupdate&id=";

    @Before
    public void initialiseMainElements(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        cmd_API = new CommandsAPI();
        myUser = new User("name99", "username99", "+3423456432", "name99@gmail.com", "9999 W Michigan St");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("^New user is created via API$")
    public void newUserIsCreatedViaAPI() throws UnirestException {
        HttpResponse<JsonNode> response = cmd_API.post_API(USERS_ENDPOINT,myUser);
        System.out.println(response.getBody().toString());
    }

    @When("^User navigates to page to update the created user$")
    public void userNavigatesToPageToUpdateTheCreatedUser() {
    }

    @And("^User types new personal data of choosed user$")
    public void userTypesNewPersonalDataOfChoosedUser() {
    }

    @And("^User clicks on update button$")
    public void userClicksOnUpdateButton() {
    }

    @Then("^User checks if data is correct$")
    public void userChecksIfDataIsCorrect() {
    }
}
