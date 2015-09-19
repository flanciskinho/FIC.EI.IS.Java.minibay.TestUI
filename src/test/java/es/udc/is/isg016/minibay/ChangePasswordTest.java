/**
 * 
 */
package es.udc.is.isg016.minibay;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author flanciskinho
 *
 */
public class ChangePasswordTest {
	private WebDriver driver;
	
	
	@Before
	public void create() throws Exception {
		driver = Util.create();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	//Create a Random Name
	private String getLoginName() {
		return "Pruebas"+Calendar.getInstance().getTimeInMillis();
	}
	
	@Test
	public void proveChangePassword() throws Exception {
		String loginName = "";
		String firstName = "Nombre Pruebas";
		String lastName  = "Apellido Pruebas";
		String email     = "pruebas@email.pruebas";
		
		String oldPassword = "pAsSw0rD.";
		String newPassword = "adSrs0WP:";
		
		driver.get(Util.INDEX_URL);
		Util.waitting();
		
		driver.findElement(By.linkText("Autenticarse")).click();
		Util.waitting();
		
		driver.findElement(By.linkText("Registrarse (usuario no registrado)")).click();
		Util.waitting();
		
		do {
			loginName = getLoginName();
			Util.register(driver, loginName, oldPassword, firstName, lastName, email);
		} while (driver.getPageSource().contains("El identificador de usuario ya existe."));
		
		driver.findElement(By.linkText("Mi cuenta")).click();
		Util.waitting();
		
		Util.changePassword(driver, oldPassword,newPassword);
		
		driver.findElement(By.linkText("Salir")).click();
		Util.waitting();
		
		driver.findElement(By.linkText("Autenticarse")).click();
		Util.waitting();
		
		Util.login(driver, loginName, newPassword);
		
		assertEquals("Página principal de MiniPortal", driver.getTitle());
		assertEquals("Hola " + firstName + " -", driver.findElement(By.id("menuWelcome")).getText() );
		
		Util.endWaitting();

	}
}
