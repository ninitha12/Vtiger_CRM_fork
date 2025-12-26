package objectRepo;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericUtils.WebDriverUtils;

public class HomePage extends WebDriverUtils{
	//declaration
	
	@FindBy(partialLinkText = "Home")
	private WebElement homeLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement conLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppLink;
	
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement pOrderLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement venLink;
	
	@FindBy(linkText = "Price Books")
	private WebElement pBookLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//a[contains(.,'Sign Out')]")
	private WebElement signoutLink;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getHomeLink() {
		return homeLink;
	}
	
	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getOppLink() {
		return oppLink;
	}

	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	public WebElement getPOrderLink() {
		return pOrderLink;
	}

	public WebElement getVenLink() {
		return venLink;
	}

	public WebElement getPBookLink() {
		return pBookLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	//implementation - business logic - action - scenario - depends on test script - whatever activity on that webpage
	public void clickOrgLink() {
		orgLink.click();
	}
	
	public void clickConLink() {
		conLink.click();
	}
	
	public void clickMoreLink() {
		moreLink.click();
	}
	
	public void clickVenLink() {
		venLink.click();
		//mouseHoverAndClickOnElement(driver, venLink);
	}
	
	public void clickProdLink() {
		prodLink.click();
	}
	
	public void clickPOrderLink() {
		pOrderLink.click();
	}
	
	public void clickCampLink() {
		campLink.click();
	}
	
	public void clickLeadLink() {
		leadLink.click();
	}
	
	public void clickOppLink() {
		oppLink.click();
	}
	
	public void clickPBookLink() {
		pBookLink.click();
	}
	
	public void clickSignoutLink() {
		signoutLink.click();
	}
	
	public void signOut(WebDriver driver) {
//		//adminImg.click();
//		mouseHover(driver, adminImg);
//		//mouseHoverAndClickOnElement(driver, signoutLink);
//		clickSignoutLink();
		
		if (driver == null) {
            Reporter.log("Driver is null, skipping logout", true);
            return;
        }

        try {
            waitUntillElementToBeVisibile(driver, 5, adminImg);
            mouseHover(driver, adminImg);
            waitUntillElementToBeVisibile(driver, 5, signoutLink);
            signoutLink.click();
        } catch (Exception e) {
            Reporter.log("Logout skipped due to exception", true);
        }
	}
	
	public void validatingLogin(WebDriver driver) {
		waitUntillElementToBeVisibile(driver, 10, homeLink);
		assertTrue(homeLink.isDisplayed(),"Login unsuccessfull");
		Reporter.log("Login successfull", true);
//		if (homeLink.isDisplayed()) {
//			System.out.println("Login successfull");
//		} else {
//			System.out.println("Login unsuccessfull");
//		}
	}
}
