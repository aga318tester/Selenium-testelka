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

public class zakladanie_konta extends rozdzielczosc {
	
	// tworzone jest nowe konto a następnie jest ono kasowane
	

	@Test
	public <Calendar> void openMyBlog() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		 
		Otwieranie_strony(driver);
		driver.manage().window().maximize();
		PobieranieTytuluStrony(driver); // pobieranie tytułu
		
		String user = "aaa@aaa.pl";
		// uzupełnienie emeila i hasła
		driver.findElement(By.id("reg_email")).click() ;
		driver.findElement(By.id("reg_email")).sendKeys(user);

		//wpisanie hasła
		driver.findElement(By.id("reg_password")).click() ;
		driver.findElement(By.id("reg_password")).sendKeys(user);

		
		
		// kliknięcie rejestruj
		js.executeScript("window.scrollBy(0,650)", "");
		driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(4) > button")).click();
	
		//js.executeScript("window.scrollBy(0,200)", "");
		//driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(4) > button")).click();

		wylogowywanie();
		
		
		js.executeScript("window.scrollBy(0,200)", "");
		logowanie(driver, user);
		
		driver.manage().timeouts().implicitlyWait(550, TimeUnit.SECONDS);
	    kasowanie_konta();
		driver.manage().timeouts().implicitlyWait(550, TimeUnit.SECONDS);
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

	public void kasowanie_konta()  // kasowanie dopiero co utworzonego konta
	{
	//	driver.findElement(By.cssSelector("#post-8 > div > div > div > p:nth-child(4)")).sendKeys(Keys.TAB , Keys.TAB, Keys.TAB,  Keys.TAB, Keys.TAB, Keys.ENTER ,Keys.ENTER);
		
	//	driver.findElement(By.linkText("Delete Account")).click();
		//*[@id="post-8"]/div/div/div/p[3]/a
	//	driver.findElement(By.partialLinkText("Delete")).click();
	// driver.findElement(By.xpath("href=\"/moje-konto/?plugin_delete_me=1399&amp;plugin_delete_me_nonce=c20ebe8edd\"")).click();
	 driver.findElement(By.xpath("href=\"/moje-konto/?plugin_delete_me=1399&amp;plugin_delete_me_nonce=c20ebe8edd\"")).sendKeys(Keys.ENTER);
		
		
	// 1d 	driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/main/article/div/div/div/p[3]/a")).sendKeys(Keys.ENTER);
		
	}
	
	public void logowanie(WebDriver driver, String user) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(user);
		driver.findElement(By.cssSelector("#password")).sendKeys(user);
		driver.findElement(By.cssSelector("button[name='login']")).click();

	}
	
	public void wylogowywanie()
	{
		driver.findElement(By.linkText("Delete Account")).click();
		
	}
}

