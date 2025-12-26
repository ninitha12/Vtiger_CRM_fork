package genericUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains generic webdriver methods
 * @author arthi
 */
public class WebDriverUtils {
	
	/**
	 * This method is used to maximize the browser window
	 * @author arthi
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait for page load
	 * @author arthi
	 * @param driver
	 * @param seconds
	 */
	public void waitForPageLoad(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	/**
	 * This method is used to wait until the element is available on webpage
	 * @author arthi
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntillElementToBeVisibile(WebDriver driver, int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until the element to be clickable
	 * @author arthi
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntillElementToBeClickable(WebDriver driver, int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to wait
	 * @author arthi
	 * @param driver
	 * @param seconds
	 */
	public void waitUntillPageLoadStatus(WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	/**
	 * This method is used to get select class reference variable of dropdown element
	 * @author arthi
	 * @param element
	 * @return
	 */
	public Select dropdown(WebElement element) {
		Select sel = new Select(element);
		return sel;
	}
	
	/**
	 * This method is used to select dropdown option by value
	 * @author arthi
	 * @param element
	 * @param value
	 */
	public void dropdownUsingValue(WebElement element, String value) {
		dropdown(element).selectByValue(value);
	}
	
	/**
	 * This method is used to select dropdown option by index
	 * @author arthi
	 * @param element
	 * @param index
	 */
	public void dropdownUsingIndex(WebElement element, int index) {
		dropdown(element).selectByIndex(index);
	}
	
	/**
	 * This method is used to select dropdown option by visible text
	 * @author arthi
	 * @param element
	 * @param text
	 */
	public void dropdownUsingVisibleText(WebElement element, String text) {
		dropdown(element).selectByVisibleText(text);
	}
	
	/**
	 * This method is used to select dropdown option by contains visible text
	 * @author arthi
	 * @param element
	 * @param containsText
	 */
	public void dropdownUsingContainsVisibleText(WebElement element, String text) {
		dropdown(element).selectByContainsVisibleText(text);
	}
	
	public void name() {
		
	}

	/**
	 * This method is used to create Actions class object and return the reference variable
	 * @author arthi
	 * @param driver
	 * @return
	 */
	public Actions actions(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}
	
	/**
	 * This method is used to move the cursor point to element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).perform();
	}
	
	/**
	 * This method is used to move the cursor point to element and click the element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).moveToElement(element).click().perform();
	}
	
	
	/**
	 * This method is used to drag the source element and drop to target element
	 * @author arthi
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropUsingSourceAndTargetElement(WebDriver driver, WebElement source, WebElement target) {
		actions(driver).dragAndDrop(source, target).perform();
	}
	
	/**
	 * This method is used to click and hold the element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldElement(WebDriver driver, WebElement element) {
		actions(driver).clickAndHold(element).perform();
	}
	
	/**
	 * This method is used to click hold and release the element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldAndRelease(WebDriver driver, WebElement element) {
		actions(driver).clickAndHold(element).release().perform();
	}
	
	/**
	 * This method is used to scroll to the element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}
	
	/**
	 * This method is used to scroll the webpage to given x and y axis
	 * @author arthi
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPage(WebDriver driver, int x, int y) {
		actions(driver).scrollByAmount(x, y).perform();
	}
	
	/**
	 * This method is used to double click on webpage
	 * @author arthi
	 * @param driver
	 */
	public void doubleClickOnWebPage(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}
	
	/**
	 * This method is used to double click on element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).doubleClick(element).perform();
	}
	
	/**
	 * This method is used to right click on webpage
	 * @author arthi
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver) {
		actions(driver).contextClick().perform();
	}
	
	/**
	 * This method is used to right click on element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();
	}
	
	/**
	 * This method is used to get the parent window handle
	 * @author arthi
	 * @param driver
	 * @return
	 */
	public String getParentWindowId(WebDriver driver) {
		String parentId = driver.getWindowHandle();
		return parentId;
	}
	
	/**
	 * This method is used to switch to child window
	 * @author arthi
	 * @param driver
	 * @param expTitle
	 */
	public void switchToWindow(WebDriver driver, String expTitle) {
		Set<String> allWindowId = driver.getWindowHandles();
		Iterator<String> it = allWindowId.iterator();
		while (it.hasNext()) {
			String currentWindow = it.next();
			String actualTitle = driver.switchTo().window(currentWindow).getTitle();
			if (actualTitle.contains(expTitle)) {
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to parent window
	 * @author arthi
	 * @param driver
	 */
	public void switchToParentWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
	}
	//frames
	/**
	 * This method is used to switch to child frame using index
	 * @author arthi
	 * @param driver
	 * @param index
	 */
	public void switchToChildFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to child frame using name
	 * @author arthi
	 * @param driver
	 * @param name
	 */
	public void switchToChildFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	
	
	/**
	 * This method is used to switch to child frame using element
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void switchToChildFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
		
	/**
	 * This method is used to switch to parent frame
	 * @author arthi
	 * @param driver
	 * @param parentWindowId
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method is used to switch to main frame
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void switchToMainFrame(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
	}
	//alert popup
	/**
	 * This method is used to accept the alert popup
	 * @author arthi
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * This method is used to cancel the alert popup
	 * @author arthi
	 * @param driver
	 */
	public void cancelAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to get the visible text from alert popup
	 * @author arthi
	 * @param driver
	 * @return
	 */
	public String getTextFromAlertPopup(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This method is used to pass data to the text field of alert popup
	 * @author arthi
	 * @param driver
	 * @param value
	 */
	public void enterValueIntoAlertTextField(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	//javascriptexecutor methods - they are unimplemented methods
	/**
	 * This method is used to typecast the driver to javascriptexecutor
	 * @author arthi
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * This method is used to scroll the webpage by scroll height using javascriptexecutor
	 * @author arthi
	 * @param driver
	 */
	public void scrollHeight(WebDriver driver) {
		JavascriptExecutor(driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}

	/**
	 * This method is used to scroll to element using javascriptexecutor
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void scrollUntillEleIsVisibleUsingJSE(WebDriver driver, WebElement element) {
		JavascriptExecutor(driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method is used to click on element using javascriptexecutor
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void clickOnElementUsingJSE(WebDriver driver, WebElement element) {
		JavascriptExecutor(driver).executeScript("arguments[0].click();", element);
	}
	
	/**
	 * This method is used to pass data to text field using javascriptexecutor
	 * @author arthi
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor(driver).executeScript("arguments[0].value=arguements[1];", element, value);
	}
	
	/**
	 * This method is used to scroll to element with x & y axis using javascriptexecutor
	 * @author arthi
	 * @param driver
	 * @param element
	 */
	public void scrollToEleUsingXYCoOrdinate(WebDriver driver, WebElement element) {
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+");");
		
	}
	//screenshot
	
	public void takeScreenshot(WebDriver driver, String fileName) {
		
	}
}
