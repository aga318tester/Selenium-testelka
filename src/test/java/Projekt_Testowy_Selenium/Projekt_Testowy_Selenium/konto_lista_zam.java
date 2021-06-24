package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import static org.junit.Assert.assertEquals;
import java.awt.Robot;
import java.awt.Toolkit;
import static org.junit.Assert.*;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class konto_lista_zam extends PierwszyTest{

	// pobieranie listy z wycieczkami

	// private static final String FileUtils = null;
	public WebDriver driver;
	int licznik = 0;
	// private String b;
//		private File file2;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

	@Before
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public <Calendar> void openMyBlog() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		// driver.manage().window().setSize(new Dimension(1200, 700));
		/*
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * driver.navigate().to(" https://fakestore.testelka.pl/moje-konto/");
		 * driver.manage().window().maximize();
		 */
		// logowanie
		super.Otwieranie_strony(driver);
		super.PobieranieTytuluStrony(driver);

		// driver.getTitle();
		// System.out.println(driver.getTitle());
		super.logowanie(driver);
		/*
		 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 * driver.findElement(By.cssSelector("input[id='username']")).
		 * sendKeys("kasiafacebook1234 ");
		 * driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
		 * driver.findElement(By.cssSelector("button[name='login']")).click();
		 * 
		 */

		// przejście na zamówienie
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Przejście na sklep

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");

		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();

		super.PobieranieTytuluStrony(driver);

		// driver.getTitle();
		// System.out.println(driver.getTitle());

		// zamówienie wycieczki
		super.ZamowienieWycieczki(driver);
		/*
		 * driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select "
		 * )).sendKeys(Keys.TAB, Keys.ENTER);
		 * driver.findElement(By.name("add-to-cart")).click();
		 * driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click()
		 * ;
		 * 
		 * 
		 * 
		 */

		// #content > div > div.woocommerce > div > a

		// driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();

		// edycja ilości wycieczek
		super.EdycjaIlosciWycieczek_zmniejszenie(driver);
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).
		 * clear();
		 * driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).
		 * click();
		 * driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).
		 * sendKeys("1"); //
		 * driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).
		 * sendKeys( Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);
		 * 
		 * driver.findElement(By.name("update_cart")).click();
		 * driver.findElement(By.name("update_cart")).sendKeys(Keys.TAB,Keys.TAB,
		 * Keys.ENTER);
		 * 
		 * 
		 */

		// moje konto -> zamówienie
		konto_zamówienie();
	//	konto_zamówienie();

		/*
		 * driver.findElement(By.cssSelector(" #menu-item-201 > a")).click();
		 * 
		 * driver.findElement(By.
		 * cssSelector("#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-account > a "
		 * )).click();
		 * 
		 * 
		 * driver.findElement(By.name("account_first_name")).clear();
		 * driver.findElement(By.name("account_first_name")).click();
		 * driver.findElement(By.name("account_first_name")).sendKeys("Agnieszka");
		 * 
		 * driver.findElement(By.name("account_display_name")).clear();
		 * driver.findElement(By.name("account_display_name")).click();
		 * driver.findElement(By.name("account_display_name")).sendKeys("Agnieszka");
		 * 
		 */

		js.executeScript("window.scrollBy(0,650)", "");
//	  driver.findElement(By.cssSelector("#post-8 > div > div > div > form > p:nth-child(9) > button")).click();

		driver.findElement(By.cssSelector(
				"#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders > a"))
				.click();

		pobieranie_tabeli();

		// Assert.assertEquals(10, licznik);

		Assert.assertEquals(10, licznik);

		driver.findElement(By.cssSelector(
	"#post-8 > div > div > div > table > tbody > tr:nth-child(1) > td.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-actions > a"))
				.click();

	}

	

	@After
	public void afterClass() {
		driver.close();
		driver.quit();
	}
/*
	public void Otwieranie_strony() {
		// otwarcie strony

		// driver.manage().window().setSize(new Dimension(1200, 700));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/moje-konto/");
		driver.manage().window().maximize();

	}

	public void logowanie() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("kasiafacebook1234 ");
		driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
		driver.findElement(By.cssSelector("button[name='login']")).click();

	}

	/*
	 * public void PobieranieTytuluStrony() { // pobieranie tytułu
	 * 
	 * driver.getTitle(); System.out.println(driver.getTitle());
	 * 
	 * }
	 */
/*
	public void EdycjaIlosciWycieczek_zmniejszenie() {
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).clear();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).click();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys("1");
		// driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys(
		// Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);

		driver.findElement(By.name("update_cart")).click();
		driver.findElement(By.name("update_cart")).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

	} */

	/*
	 * public void ZamowienieWycieczki() {
	 * driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select "
	 * )).sendKeys(Keys.TAB, Keys.ENTER);
	 * driver.findElement(By.name("add-to-cart")).click();
	 * driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click()
	 * ; }
	 */

	/*
	 * public void Przejscie_na_sklep() { // Przejście na sklep
	 * 
	 * driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
	 * driver.navigate().to(" https://fakestore.testelka.pl/shop/");
	 * 
	 * driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).
	 * click(); }
	 * 
	 */
/*
	public void logowanie() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("kasiafacebook1234 ");
		driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
		driver.findElement(By.cssSelector("button[name='login']")).click();

	} 

	public void PobieranieTytuluStrony() {
		// pobieranie tytułu

		driver.getTitle();
		System.out.println(driver.getTitle());

	} */

	/*
	public void EdycjaIlosciWycieczek_zmniejszenie() {
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).clear();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).click();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys("1");
		// driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys(
		// Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);

		driver.findElement(By.name("update_cart")).click();
		driver.findElement(By.name("update_cart")).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

	}*/

	public void ZamowienieWycieczki() {
		driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select ")).sendKeys(Keys.TAB, Keys.ENTER);
		driver.findElement(By.name("add-to-cart")).click();
		driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();
	}
/*
	public void Przejscie_na_sklep() {
		// Przejście na sklep

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");

		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();
	}
*/
	public void pobieranie_tabeli() {
		// List<WebElement> tableRows =
		// driver.findElements(By.xpath("//*[@id=\"post-8\"]/div/div/div"));

		// pobieranie wyników tabela
		List<WebElement> tableRows = driver
				.findElements(By.cssSelector(" #post-8 > div > div > div > table > tbody > tr"));

		System.out.println("Size of List: " + tableRows);

		for (WebElement element : tableRows) {

			licznik++;
			System.out.println(element.getText());

			System.out.println("************************************************************************");
		}
		System.out.println("liczba pozycji w tabeli" + "  " + licznik);

	}

	public void konto_zamówienie() {
		// moje konto -> zamówienie
		driver.findElement(By.cssSelector(" #menu-item-201 > a")).click();

		driver.findElement(By.cssSelector(
				"#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-account > a "))
				.click();

		driver.findElement(By.name("account_first_name")).clear();
		driver.findElement(By.name("account_first_name")).click();
		driver.findElement(By.name("account_first_name")).sendKeys("Agnieszka");

		driver.findElement(By.name("account_display_name")).clear();
		driver.findElement(By.name("account_display_name")).click();
		driver.findElement(By.name("account_display_name")).sendKeys("Agnieszka");
	}

}
