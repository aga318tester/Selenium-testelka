package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class drugitest {

	// dodawanie wycieczki do zamówienia

	// private static final String FileUtils = null;
	public WebDriver driver;
	// private String b;
    // private File file2;
    // SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	

	@Test
	public <Calendar> void openMyBlog() {

		
		Otwieranie_strony(driver);
		PobieranieTytuluStrony(driver); // pobieranie tytułu
		logowanie(driver); // logowanie
		Przejscie_na_sklep(driver); // przejście na zamówienie
		PobieranieTytuluStrony(driver); // pobieranie tytułu
		ZamowienieWycieczki(driver); // zamówienie wycieczki
		EdycjaIlosciWycieczek_zmniejszenie(driver); // edycja ilości zamówionych wycieczek

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

	protected void Otwieranie_strony(WebDriver driver) {
		// otwarcie strony

		// driver.manage().window().setSize(new Dimension(1200, 700));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/moje-konto/");
		driver.manage().window().maximize();

	}

	protected void logowanie(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("kasiafacebook1234 ");
		driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
		driver.findElement(By.cssSelector("button[name='login']")).click();

	}

	protected void PobieranieTytuluStrony(WebDriver driver) {
		// pobieranie tytułu

		driver.getTitle();
		System.out.println(driver.getTitle());

	}

	protected void EdycjaIlosciWycieczek_zmniejszenie(WebDriver driver) {
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).clear();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).click();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys("1");
		// driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys(
		// Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);

		driver.findElement(By.name("update_cart")).click();
		driver.findElement(By.name("update_cart")).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

	}

	protected void ZamowienieWycieczki(WebDriver driver) {
		driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select ")).sendKeys(Keys.TAB, Keys.ENTER);
		driver.findElement(By.name("add-to-cart")).click();
		driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();
	}

	protected void Przejscie_na_sklep(WebDriver driver) {
		// Przejście na sklep

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");

		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();
	}

	
}
