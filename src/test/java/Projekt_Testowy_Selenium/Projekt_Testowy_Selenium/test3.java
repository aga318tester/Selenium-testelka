package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test3 extends konto_lista_zam {

	// usuwanie pozycji zamówienia

	// private static final String FileUtils = null;
	public WebDriver driver;
	// private String b;
//		private File file2;
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

	@Test
	public <Calendar> void openMyBlog() {

		super.Otwieranie_strony(driver);
		super.PobieranieTytuluStrony(driver);

		super.logowanie(driver);

		// przejście na zamówienie
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Przejście na sklep
       super.Przejscie_na_sklep(driver);
		super.PobieranieTytuluStrony(driver);
		super.ZamowienieWycieczki(driver); // zamówienie wycieczki

		driver.findElement(By.cssSelector(" #menu-item-200 > a")).click();

		// kliknięcie x na liście zamówień, które usuwa pozycje z zamówienia

		driver.findElement(By.cssSelector(
				"#post-6 > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-remove > a"))
				.click();

	}

	@Before
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

	}

	@After
	public void afterClass() {
		 driver.close();
		 driver.quit();
	}

	protected void Przejscie_na_sklep(WebDriver driver) {
		// Przejście na sklep

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");
		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();
	}
	
}
