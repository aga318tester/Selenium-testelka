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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.errorprone.annotations.FormatString;

public class PierwszyTest extends drugitest
{
	// realizacja zamówienia
	// przed odpaleniem tego testu musi być puszcz0ny test :drugitest

	private static final String FileUtils = null;
	public WebDriver driver;
	private String b;
//	private File file2;
//	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

	
	@Before
	public void beforeClass() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		this.driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public <Calendar> void openMyBlog() 
	{
        // odwołanie do metod z klasy "drugitest"
		
		super.Otwieranie_strony(driver);
		super.PobieranieTytuluStrony(driver); // pobieranie tytułu
		super.logowanie(driver); // logowanie
		super.Przejscie_na_sklep(driver); // przejście na zamówienie
		super.PobieranieTytuluStrony(driver); // pobieranie tytułu
		super.ZamowienieWycieczki(driver); // zamówienie wycieczki


		przejście_na_zamowienie();
		formularz_zamowienia();
	}

	

	@After
	public void afterClass()
	{
		 driver.quit();
		// driver.close();
	}

	
	public void formularz_zamowienia() 
	{
		// uzupełnianie formularza z zamówienia
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#billing_first_name")).clear();
		driver.findElement(By.cssSelector(" #billing_last_name")).clear();
		driver.findElement(By.cssSelector(" #billing_address_1")).clear();
		driver.findElement(By.cssSelector(" #billing_city")).clear();
		driver.findElement(By.cssSelector(" #billing_postcode")).clear();
		driver.findElement(By.cssSelector(" #billing_phone")).clear();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Aga");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(" #billing_last_name")).sendKeys("Aga2");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(75, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(" #billing_address_1")).sendKeys("warszaawska");
		driver.findElement(By.cssSelector(" #billing_city")).sendKeys("warszawa");
		driver.findElement(By.cssSelector(" #billing_postcode")).sendKeys("25-200");
		driver.findElement(By.cssSelector(" #billing_phone")).sendKeys("666-555-444");
		driver.findElement(By.cssSelector("#billing_phone")).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,Keys.TAB);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.findElement(By.id("terms")).click();
		driver.manage().timeouts().implicitlyWait(210, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		// nie łapie przycisku
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	    // driver.findElement(By.id("place_order")).click();
	    driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.findElement(By.name("woocommerce_checkout_place_order")).click();
	}

	public void przejście_na_zamowienie()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#menu-item-199 > a")).click();
		driver.findElement(By.cssSelector("input[id='billing_first_name']")).click();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}
	}
	
