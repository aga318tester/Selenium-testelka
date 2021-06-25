package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowStateListener;
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
// import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

// @SuppressWarnings("unused")
public class rozdzielczosc extends RAbatZamówienia 
{

//	public interface FileUtils {

	//}

//	private static final String FileUtils = null;

	public WebDriver driver;

	// TakesScreenshot scrShot = ((TakesScreenshot)driver);
	// File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	@Test
	public <Calendar> void openMyBlog() {

		// otwieranie strony

		Otwieranie_strony(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		// pobieranie tytułu
		
		super.PobieranieTytuluStrony(driver);
		js.executeScript("window.scrollBy(0,250)", "");
		logowanie(driver);


		// Przejście na sklep
	//	js.executeScript("window.scrollBy(0,250)", "");
	//	super.Przejscie_na_sklep(driver);
		przejscie_sklep_rozdzielczość();
		

		js.executeScript("window.scrollBy(0,500)", "");
		

		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();
		js.executeScript("window.scrollBy(0,450)", "");

		super.PobieranieTytuluStrony(driver); // pobieranie tytułu

	//	js.executeScript("window.scrollBy(0,450)", "");
	//	super.ZamowienieWycieczki(driver);
		// zamówienie wycieczki
		
		driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select ")).sendKeys(Keys.TAB, Keys.ENTER);

		js.executeScript("window.scrollBy(0,450)", "");

		driver.findElement(By.name("add-to-cart")).click();
		
	//	super.ZamowienieWycieczki(driver);

		//
		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();
		// #content > div > div.woocommerce > div > a

		js.executeScript("window.scrollBy(0,450)", "");
		driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();
		

		EdycjaIlosciWycieczek_rozdzielczosc(); // edycja ilości wycieczek

		js.executeScript("window.scrollBy(0,450)", "");

//  // driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys( Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);

		js.executeScript("window.scrollBy(0,450)", "");

		driver.findElement(By.name("update_cart")).click();
		driver.findElement(By.name("update_cart")).sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);

//  takeSnapShot(driver, "c://test.png");

		// scrShot.getScreenshotAs(OutputType.FILE);
	}

	/*
	 * 
	 * private void takeSnapShot1(WebDriver driver, String fileWithPath) { // TODO
	 * Auto-generated method stub TakesScreenshot scrShot =
	 * ((TakesScreenshot)driver);
	 * 
	 * 
	 * 
	 * File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
	 * 
	 * //Move image file to new destination
	 * 
	 * File DestFile=new File(fileWithPath);
	 * 
	 * //Copy file at dest
	 * 
	 * // FileUtils.copyFile(SrcFile, DestFile);
	 * 
	 * }
	 */

	/*
	 * 
	 * public static void takeSnapShot(WebDriver driver, String fileWithPath) throws
	 * Exception{
	 * 
	 * //Convert web driver object to TakeScreenshot
	 * 
	 * TakesScreenshot scrShot =((TakesScreenshot)driver);
	 * 
	 * 
	 * 
	 * File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	 * 
	 * //Move image file to new destination
	 * 
	 * File DestFile=new File(fileWithPath);
	 * 
	 * //Copy file at dest scrShot.getScreenshotAs(OutputType.FILE); //
	 * FileUtils.copyFile(SrcFile, DestFile);
	 * 
	 * }
	 * 
	 * 
	 */

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

		 driver.manage().window().setSize(new Dimension(1200, 700));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/moje-konto/");
	//	driver.manage().window().maximize();

	}


	public void ZamowienieWycieczki_rozdzielczosc() {
		driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select ")).sendKeys(Keys.TAB, Keys.ENTER);

		js.executeScript("window.scrollBy(0,450)", "");

		driver.findElement(By.name("add-to-cart")).click();
	}

	protected void logowanie(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("kasiafacebook1234 ");
		driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
	//	driver.findElement(By.cssSelector("button[name='login']")).click();

	}
	public void EdycjaIlosciWycieczek_rozdzielczosc() {
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).clear();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).click();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys("1");

	}

	public void przejscie_sklep_rozdzielczość() {
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");

	}
}
