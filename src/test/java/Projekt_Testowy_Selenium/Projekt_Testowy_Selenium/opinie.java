package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;


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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;
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
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		
		driver.findElement(By.className("onsale")).click();
		
		
		// przejście na opinie i jej dodanie
		js.executeScript("window.scrollBy(0,550)", "");
		
		driver.findElement(By.cssSelector("#tab-title-reviews > a")).click();
		
//generowanie randomowego numer
		 
		//losowanie_random();
		Random objGenerator = new Random();
	    for (int iCount = 0; iCount< 1; iCount++){
	      int randomNumber = objGenerator.nextInt(100000000);
	  //    System.out.println("Random No : " + randomNumber); 
		
          WebElement element = driver.findElement(By.cssSelector("#comment"));
          Actions actions = new Actions(driver);
          actions.moveToElement(element);
          actions.perform();
		
          
		// wystawianie gwiazdek w opinii
    //     js.executeScript("window.scrollBy(0,500)", "");
	     driver.findElement(By.cssSelector("#commentform > div > p > span > a.star-5")).click();
	//	js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(By.cssSelector("#comment")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	   driver.findElement(By.cssSelector("#comment")).sendKeys("było super"+randomNumber);
   
	   js.executeScript("window.scrollBy(0,500)", "");
	   driver.findElement(By.id("submit")).click();
        }
		
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


public void losowanie_random()
{
	Random objGenerator = new Random();
    for (int iCount = 0; iCount< 1; iCount++){
      int randomNumber = objGenerator.nextInt(100000000);
  //    System.out.println("Random No : " + randomNumber); 

}
}}



