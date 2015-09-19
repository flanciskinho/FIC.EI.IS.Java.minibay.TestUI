/**
 * 
 */
package es.udc.is.isg016.minibay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author flanciskinho
 *
 */
public class MakeBidTest {
	/**
	 * Para no hacer el test muy largo se va a trabajar sobre los datos que hay existentes en la BD
	 */
	String loginName = "fcedron";
	String password  = "pass";
	
	String productName = "Motor Nema 17";
	String keywords    = productName.split(" ")[0];
	
	private WebDriver driver;
	
	@Before
	public void create() throws Exception {
		driver = Util.create();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private void search() {
		Util.searchProduct(driver, keywords);
		
		driver.findElement(By.linkText(productName)).click();
		Util.waitting();
	}
	
	@Test
	public void proveMakeBid() {
		driver.get(Util.INDEX_URL);
		Util.waitting();
		
		search();
		
		driver.findElement(By.linkText("Autenticarse")).click();
		Util.waitting();
		
		Util.login(driver, loginName, password);
		
		search();
		
		Util.pressBid(driver);
		
		assertEquals(this.productName, driver.findElement(By.id("productName")).getText());
		
		String productName  = driver.findElement(By.id("productName")).getText();
		String categoryName = driver.findElement(By.id("categoryName")).getText();
		String description  = driver.findElement(By.id("description")).getText();
		String shipment     = driver.findElement(By.id("shipment")).getText();
		
		String endTime      = driver.findElement(By.id("endTime")).getText();
		String initPrice    = driver.findElement(By.id("initPrice")).getText();
		String owner        = driver.findElement(By.id("owner")).getText();
		
		String bidValue = driver.findElement(By.id("minimunBid")).getText();
		bidValue = bidValue.substring(12).trim();//.replaceAll(",", "").replaceAll("\\.", ""); //Puja minima:
		
		Util.makeBid(driver, bidValue);
		
		driver.findElement(By.linkText("Mis apuestas")).click();
		Util.waitting();
		
		driver.findElement(By.linkText(productName)).click();
		Util.waitting();
		
		assertEquals(productName  , driver.findElement(By.id("productName")).getText());
		assertEquals(categoryName , driver.findElement(By.id("categoryName")).getText());
		assertEquals(description  , driver.findElement(By.id("description")).getText());
		assertEquals(shipment     , driver.findElement(By.id("shipment")).getText());
		assertEquals(endTime      , driver.findElement(By.id("endTime")).getText());
		assertEquals(initPrice    , driver.findElement(By.id("initPrice")).getText());
		assertEquals(owner        , driver.findElement(By.id("owner")).getText());
		
		
		Util.endWaitting();
	}
}
