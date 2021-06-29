package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zakladanie_konta extends rozdzielczosc {
	
	

	@Test
	public <Calendar> void openMyBlog() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		 
		Otwieranie_strony(driver);
		driver.manage().window().maximize();
		PobieranieTytuluStrony(driver); // pobieranie tytułu
		
		
		// uzupełnienie emeila i hasła
		driver.findElement(By.id("reg_email")).click() ;
		driver.findElement(By.id("reg_email")).sendKeys("aaa@aaa.pl");

		//wpisanie hasła
		driver.findElement(By.id("reg_password")).click() ;
		driver.findElement(By.id("reg_password")).sendKeys("aaa@aaa.pl");

		
		
		// kliknięcie rejestruj
		js.executeScript("window.scrollBy(0,650)", "");
		driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(4) > button")).click();
	
		//js.executeScript("window.scrollBy(0,200)", "");
		//driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(4) > button")).click();

	
	
	
	
	
	
	}

	@Before
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
	
	}

	@After
	public void afterClass() {
	//.close();
	//	driver.quit();

	}

	
	
}

