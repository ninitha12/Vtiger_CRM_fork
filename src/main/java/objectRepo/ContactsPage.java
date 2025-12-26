package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContImg;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateContImg() {
		return createContImg;
	}
		
	//implementation
	public void clickCreateContImg() {
		createContImg.click();
	}

}
