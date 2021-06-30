package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bind.annotation.Super;


public class opinie extends zakladanie_konta{
// dodawanie opinii do wycieczki
	
	@Test
	public <Calendar> void openMyBlog() {
		
	
		this.Otwieranie_strony(driver);
		driver.manage().window().maximize();
		
		
		this.logowanie(driver);
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		
		this.Przejscie_na_sklep(driver);
		
		// wybór wycieczki
		
		driver.findElement(By.linkText("Yoga i pilates")).click();
	//	driver.findElement(By.xpath("?add-to-cart=60\" data-quantity=\"1")).click();
		//driver.findElement(By.name("orderby")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		
		driver.findElement(By.className("onsale")).click();
		
		
		// przejście na opinie i jej dodanie
	}

	@Before
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
	
	}

	@After
	public void afterClass() {
//	driver.close();
//	driver.quit();

	}


		
	

}



