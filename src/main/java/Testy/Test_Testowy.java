package Testy;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Testowy {

	@Test
	public void test() {

	   WebDriver driver = new ChromeDriver();
       driver.get("www.google.com");
       
	}
}
