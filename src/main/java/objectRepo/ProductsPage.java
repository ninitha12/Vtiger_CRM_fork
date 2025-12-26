package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	// declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProdImg;

	// initialization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getCreateProdImg() {
		return createProdImg;
	}

	// implementation
	public void clickCreateProdImg() {
		createProdImg.click();
	}

}
