/**
 * 
 */
package es.udc.is.isg016.minibay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author flanciskinho
 *
 */
public class Util {
	
	public final static String    INDEX_URL = "http://localhost:9090/minibay";
	
	private final static long TIME_PER_PAUSE = 0;
	private final static long TIME_FOR_PRESS = TIME_PER_PAUSE/5;
	private final static long END_TIME = TIME_PER_PAUSE*2;
	
	
	public static WebDriver create() {
		WebDriver driver = new FirefoxDriver(new FirefoxProfile());
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        
        return driver;
	}
	
	private static void waitting(long t)  {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitting()  {
		waitting(TIME_PER_PAUSE);	
	}
	
	public static void waittingForPress()  {
		waitting(TIME_FOR_PRESS);	
	}
	
	public static void endWaitting()  {
		waitting(END_TIME);	
	}
	
	public static void searchProduct(WebDriver driver, String keywords) {
		driver.findElement(By.id("keywords")).clear();
		driver.findElement(By.id("keywords")).sendKeys(keywords);
		
		waittingForPress();
		
		driver.findElement(By.cssSelector("input.t-button")).click();
		
		waitting();
	}
	
	public static void register(WebDriver driver, String login, String password, String firstName, String lastName, String email) {
        driver.findElement(By.id("loginName")).clear();
        driver.findElement(By.id("loginName")).sendKeys(login);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("retypePassword")).clear();
        driver.findElement(By.id("retypePassword")).sendKeys(password);
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        waittingForPress();
        
        driver.findElement(By.cssSelector("input.t-button")).click();
        
        waitting();
	}
	
	public static void pressBid(WebDriver driver) {
		waittingForPress();
		
        driver.findElement(By.id("makeBid")).click();
        
        waitting();
	}
	
	public static void makeBid(WebDriver driver, String value) {
		driver.findElement(By.id("bidInput")).clear();
		driver.findElement(By.id("bidInput")).sendKeys(value);
		
		waittingForPress();
		
        driver.findElement(By.id("submitBid")).click();
        
        waitting();
	}
	
	public static void changePassword(WebDriver driver, String oldPassword, String newPassword) {
		driver.findElement(By.id("oldPassword")).clear();
        driver.findElement(By.id("oldPassword")).sendKeys(oldPassword);
        driver.findElement(By.id("newPassword")).clear();
        driver.findElement(By.id("newPassword")).sendKeys(newPassword);
        driver.findElement(By.id("retypeNewPassword")).clear();
        driver.findElement(By.id("retypeNewPassword")).sendKeys(newPassword);

        waittingForPress();
        
        driver.findElement(By.id("submitFormPassword")).click();
        
        waitting();
	}
	
	public static void login(WebDriver driver, String logname, String password) {
		driver.findElement(By.id("loginName")).clear();
        driver.findElement(By.id("loginName")).sendKeys(logname);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        waittingForPress();
        
        driver.findElement(By.cssSelector("input.t-button")).click();
        
        waitting();
	}
}
