package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{
	//declaration
	//@FindBy(name = "user_name")
	@FindBy(xpath = "//input[contains(@name,'user_name')]")
	private WebElement usernameInput;
	
	@FindBy(name = "user_password")
	private WebElement passwordInput;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	//utilization

	public WebElement getUsernameInput() {
		return usernameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//implementation
	//business logic
	public void loginUser(String username, String password, WebDriver driver) {
//		usernameInput.sendKeys(username);
//		passwordInput.sendKeys(password);
//		loginBtn.click();
		
		waitUntillElementToBeVisibile(driver, 20, usernameInput);
        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
	}

}
