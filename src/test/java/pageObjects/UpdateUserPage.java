package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import POJOs.User;

public class UpdateUserPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public UpdateUserPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "users-id")
    WebElement idInput;

    @FindBy(id = "users-name")
    WebElement nameInput;

    @FindBy(id = "users-username")
    WebElement usernameInput;

    @FindBy(id = "users-email")
    WebElement emailInput;

    @FindBy(id = "users-phone")
    WebElement phoneInput;

    @FindBy(id = "users-address")
    WebElement addressInput;

    @FindBy(xpath = "//tr[1]/td")
    WebElement idTableData;

    @FindBy(xpath = "//tr[2]/td")
    WebElement nameTableData;

    @FindBy(xpath = "//tr[3]/td")
    WebElement usernameTableData;

    @FindBy(xpath = "//tr[4]/td")
    WebElement emailTableData;

    @FindBy(xpath = "//tr[5]/td")
    WebElement addressTableData;

    @FindBy(xpath = "//tr[6]/td")
    WebElement phoneTableData;

    @FindBy(xpath = "//*[@id='w0']/div[7]/button")
    WebElement saveBtn;

    @FindBy(xpath = "//div/p/a[1]")
    WebElement updateBtn;

    @FindBy(xpath = "//div/p/a[2]")
    WebElement deleteBtn;


    public String getId(){
        wait.until(ExpectedConditions.visibilityOf(idTableData));
        return idTableData.getText();
    }
    public void typeName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public String getName(){
        return nameTableData.getText();
    }

    public void typeUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public String getUsername(){
        return usernameTableData.getText();
    }

    public void typeEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public String getEmail(){
        return emailTableData.getText();
    }

    public void typePhone(String phone){
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public String getPhone(){
        return phoneTableData.getText();
    }

    public void typeAddress(String address){
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public String getAddress(){
        return addressTableData.getText();
    }

    public void clickSave(){
        saveBtn.click();
    }

    public void clickUpdate(){
        updateBtn.click();
    }

    public void clickDelete(){
        deleteBtn.click();
    }

    public void updateUser(User user){
        this.typeName(user.name);
        this.typeUsername(user.username);
        this.typeEmail(user.email);
        this.typeAddress(user.address);
        this.typePhone(user.phone);
        clickSave();
    }

}
