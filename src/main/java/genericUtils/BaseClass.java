package genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public DataBaseUtils dbLib = new DataBaseUtils();
	public FileUtils fLib = new FileUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public JavaUtils jLib = new JavaUtils();

	public WebDriver driver;
//	public static WebDriver sdriver; 
	
	// ThreadLocal WebDriver
    public static ThreadLocal<WebDriver> wdriver = new ThreadLocal<WebDriver>();//map concept

    // Getter for Listener / Utilities
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
    
    //Replace static WebDriver with ThreadLocal<WebDriver>

	@BeforeSuite(alwaysRun = true)
	public void connectToDb() throws SQLException {
		dbLib.connectToDB();
		System.out.println("---connected to DB---");
	}

	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws IOException {
	//public void launchBrowser() throws IOException {	
		//String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		//
		//WebDriver localDriver =null;
		
		// launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			//localDriver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			//localDriver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			//localDriver = new EdgeDriver();
		}
		else {
	        //throw new SkipException("Unsupported browser: " + BROWSER);
			driver = new ChromeDriver();
	    }
		// set driver to ThreadLocal
        //driver.set(localDriver);
		wdriver.set(driver);
		
		//sdriver = driver;
		// maximize window
		wLib.maximizeWindow(driver);
		//wLib.maximizeWindow(getDriver());
		// enter URL
		driver.get(URL);
		//getDriver().get(URL);
		// wait for page load
		wLib.waitForPageLoad(driver, 10);
		//wLib.waitForPageLoad(getDriver(), 10);
		System.out.println("---browser launched successfully---");
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToAppn() throws IOException {
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		//LoginPage lp = new LoginPage(getDriver());
		lp.loginUser(USERNAME, PASSWORD,driver);
		System.out.println("---logged into application---");
		
		//WebDriver drv = getDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromAppn() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		//HomePage hp = new HomePage(getDriver());
		//hp.signOut(getDriver());
		System.out.println("---logged out from application---");
		
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		//getDriver().quit();
		//wdriver.remove();
		System.out.println("---browser closed successfully---");
		
	}

	@AfterSuite(alwaysRun = true)
	public void disconnectFromDB() throws SQLException {
		dbLib.disconnectDB();
		System.out.println("---disconnected from DB---");
	}

}
