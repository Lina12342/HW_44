package core;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Linear {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/firefox");
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://alex.academy/exe/signup/www/index.php");
		
		driver.findElement(By.id("id_fname")).sendKeys("Elena");
		driver.findElement(By.id("id_lname")).sendKeys("Nicolaeva");
		driver.findElement(By.id("id_email")).sendKeys("nicolaevaa113@gmail.com");
		driver.findElement(By.id("id_phone")).sendKeys("415 7679838");
		driver.findElement(By.id("id_submit_button")).click();
		System.out.println(driver.getTitle().equals("Confirmation") ? "pass" : "fail");
		driver.quit();
	}

static String browser;
static WebDriver driver;
static Writer report;
static Properties p = new Properties();
static String url;


public static boolean isElementPresent(By by) {
    if (!driver.findElements(by).isEmpty()) return true; else return false;}

public static String getSize(By by) {
    if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
   	 return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x"); else return "null";}

public static String getLocation(By by) {
    if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
   	 return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x"); else return "null";}

public static void setValue(By by, String value) {
    if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
    	  driver.findElement(by).sendKeys(p.getProperty(value));}

public static String getValue(By by) {
    if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
   	 return driver.findElement(by).getText(); else return "null";}


public static void main1(String[] args) throws Exception {
	p.load(new FileInputStream("./input.properties"));
	Logger.getLogger("").setLevel(Level.OFF);
	String driverPath = "";

	if (System.getProperty("os.name").toUpperCase().contains("MAC"))
		driverPath = "./resources/webdrivers/mac/geckodriver.sh";
	else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
		driverPath = "./resources/webdrivers/pc/geckodriver.exe";
	else throw new IllegalArgumentException("Unknown OS");

	System.setProperty("webdriver.gecko.driver", driverPath);
	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}


//SignUp validation		
		static void validateSignUp() throws IOException {
			p.load(new FileInputStream("./input.properties"));
			url = p.getProperty("url");
			String browser1 = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toString().trim();
			browser = browser1.replaceFirst(String.valueOf(browser1.charAt(0)), String.valueOf(browser1.charAt(0)).toUpperCase());
			report = new FileWriter("./report_linear_" + browser.toString().toLowerCase() + ".csv", false);
			report.write("#," + browser + ",Page,Field,isPresent,Value,Size,Location" + "\n");
			System.out.print("#," + browser + ",Page,Field,isPresent,Value,Size,Location" + "\n");
			String file1 = driver.getCurrentUrl().toString().trim();
			String file = file1.substring(file1.lastIndexOf('/') + 1);
			
			// 1 :: First Name
		

		try{
			 driver.findElements(By.id("fname_id"));
			 //Since, no exception, so element is present
			 System.out.println("Element present");
			}
			catch(NoSuchElementException e){
			 //Element is not present
			 System.out.println("Element not present");}
		


	// 2 :: Last name
		

		try{
			 driver.findElements(By.id("lname_id"));
			 //Since, no exception, so element is present
			 System.out.println("Element present");
			}
			catch(NoSuchElementException e){
			 //Element is not present
			System.out.println("Element not present");}
		
		
		
		
		// 3 :: Email
		
		try{
			 driver.findElements(By.id("email_id"));
			 //Since, no exception, so element is present
			 System.out.println("Element present");
			}
			catch(NoSuchElementException e){
			 //Element is not present
			 System.out.println("Element not present");}
		
		
		
		// 4 :: Phone
		
		try{
			 driver.findElements(By.id("phone_id"));
			 //Since, no exception, so element is present
			 System.out.println("Element present");
			}
			catch(NoSuchElementException e){
			 //Element is not present
			 System.out.println("Element not present");}
		
		
		


		// SUBMIT
		By submit = By.id(p.getProperty("submit_id"));
		if (!driver.findElements(submit).isEmpty() && driver.findElement(submit).isDisplayed())
			driver.findElement(submit).submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Confirmation"));
		report.flush();
		report.close();}
		
		
		
		// Confirmation validation
				static void validateConfirmation() throws IOException {
					p.load(new FileInputStream("./input.properties"));
					report = new FileWriter("./report_linear_" + browser.toString().toLowerCase() + ".csv", true);
					String file1 = driver.getCurrentUrl().toString().trim();
					String file = file1.substring(file1.lastIndexOf('/') + 1);
					
					
					
					// 5 :: First Name
					

					try{
						 driver.findElements(By.id("fname_id"));
						 //Since, no exception, so element is present
						 System.out.println("Element present");
						}
						catch(NoSuchElementException e){
						 //Element is not present
						 System.out.println("Element not present");}
					


				// 6 :: Last name
					

					try{
						 driver.findElements(By.id("lname_id"));
						 //Since, no exception, so element is present
						 System.out.println("Element present");
						}
						catch(NoSuchElementException e){
						 //Element is not present
						System.out.println("Element not present");}
					
					
					
					
					// 7 :: Email
					
					try{
						 driver.findElements(By.id("email_id"));
						 //Since, no exception, so element is present
						 System.out.println("Element present");
						}
						catch(NoSuchElementException e){
						 //Element is not present
						 System.out.println("Element not present");}
					
					
					
					// 8 :: Phone
					
					try{
						 driver.findElements(By.id("phone_id"));
						 //Since, no exception, so element is present
						 System.out.println("Element present");
						}
						catch(NoSuchElementException e){
						 //Element is not present
						 System.out.println("Element not present");}
					
				
					report.flush();
					report.close();
				}}
					
					
					
					
