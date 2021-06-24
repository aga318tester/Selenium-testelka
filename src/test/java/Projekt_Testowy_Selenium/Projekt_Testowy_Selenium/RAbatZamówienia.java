package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.regex.Pattern.compile;

public class RAbatZamówienia extends test3 {
//  dodawanie wycieczki do zamówienia oraz rabatu
// rabat jest aktywny 

	// private static final String FileUtils = null;
	public WebDriver driver;

	@Test
	public <Calendar> void openMyBlog() throws UnsupportedEncodingException {

		
		Otwieranie_strony();  // otwieranie strony
		PobieranieTytuluStrony(); 	// pobieranie tytułu
		logowanie();  	// logowanie

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 	// przejście na zamówienie
		Przejscie_na_sklep();  // Przejście na sklep


		// pobieranie tytułu strony do zmiennej

		PobieranieTytuluStrony();
		String a;
		a = driver.getTitle();
		System.out.println(driver.getTitle());

	
		ZamowienieWycieczki(); 	// zamówienie wycieczki
		EdycjaIlosciWycieczek_zmniejszenie_kupon(); 	// edycja ilości wycieczek
		

		// pobranie kwoty do zapłaty z labelki
		String c = driver.findElement(By.cssSelector("#order_review > table > tfoot > tr.cart-subtotal > td > span")).getText();

		// ucinanie znaku waluty z kwoty
		c = c.substring(0, c.length() - 6).trim();
		c = c.replaceAll("\\s+", "");
		// c1= Integer.parseInt(c);

		System.out.println(c);
		int c1 = Integer.parseUnsignedInt(c);


		// pobranie kuponu

		String kupon = driver.findElement(By.cssSelector("#order_review > table > tfoot > tr.cart-discount.coupon-kwotowy250 > td > span")).getText();

		//ucinanie oznaczenia waluty z kwoty kuponu
		kupon = kupon.substring(0, kupon.length() - 6);
		System.out.println(kupon);

		int kupon1 = Integer.parseUnsignedInt(kupon);
		int kasa = c1 - kupon1;
		int kasa1 = Integer.parseUnsignedInt(kupon);

		System.out.println("do zapłaty" + " " + kasa);

		String cena_z_strony = driver
		.findElement(By.cssSelector("#order_review > table > tfoot > tr.order-total > td > strong > span")).getText();
		cena_z_strony = cena_z_strony.substring(0, cena_z_strony.length() - 6);

		cena_z_strony = cena_z_strony.replaceAll("\\s+", "");
		// System.out.println(kupon);

		int cena_z_strony1 = Integer.parseUnsignedInt(cena_z_strony);
		int kasa12 = c1 - kupon1;
		System.out.println("do zaplaty na stronie" + " " + cena_z_strony);

		
		Assert.assertEquals(kasa12, cena_z_strony1);
		Assert.assertEquals(a.toString().trim() == ("Windsurfing – FakeStore").toString().trim(), false);

		a = a.replaceAll("\\s+", "").trim();
		String tekst_strona = "Windsurfing-FakeStore";

	/*	if (a.contains(tekst_strona)) 
		{

			System.out.println("jest ok");
		}

		System.out.println("lipaaa " + a);
*/
	}

	@Before
	public void beforeClass() 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver32.exe");
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

	}

	@After
	public void afterClass()
	{
		// driver.close();
		// driver.quit();
	}

	public void Otwieranie_strony()
	{
		// otwarcie strony

		// driver.manage().window().setSize(new Dimension(1200, 700));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/moje-konto/");
		driver.manage().window().maximize();

	}

	public void logowanie() 
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("kasiafacebook1234 ");
		driver.findElement(By.cssSelector("#password")).sendKeys("Biedronka123@");
		driver.findElement(By.cssSelector("button[name='login']")).click();

	}

	public void PobieranieTytuluStrony() 
	{
		// pobieranie tytułu

		driver.getTitle();
		System.out.println(driver.getTitle());

	}

	public void ZamowienieWycieczki()
	{
		driver.findElement(By.cssSelector("#main > div:nth-child(2) > form > select ")).sendKeys(Keys.TAB, Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.findElement(By.name("add-to-cart")).click();
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a")).click();
	}

	public void Przejscie_na_sklep() 
	{
		// Przejście na sklep

		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.navigate().to(" https://fakestore.testelka.pl/shop/");
		driver.findElement(By.cssSelector("#main > ul > li:nth-child(1) > a > h2")).click();
	}

	public void EdycjaIlosciWycieczek_zmniejszenie_kupon() 
	{
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).clear();
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).click();
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.findElement(By.name("cart[39461a19e9eddfb385ea76b26521ea48][qty]")).sendKeys("1"); 
		driver.manage().timeouts().pageLoadTimeout(750, TimeUnit.SECONDS);
		driver.findElement(By.name("coupon_code")).sendKeys("kwotowy250"); // , Keys.TAB, Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.findElement(By.name("apply_coupon")).click();
		driver.findElement(By.name("apply_coupon")).sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB);
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div/div/a")).click();

	}

	
}
