package Projekt_Testowy_Selenium.Projekt_Testowy_Selenium;

import static org.junit.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.google.errorprone.annotations.FormatString;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.sun.jna.platform.FileUtils;

public class screen {
	
	String path;
    WebDriver driver = new ChromeDriver();
    
    //TakesScreenshot scrShot = ((TakesScreenshot)driver);
    // File SrcFile=scrShot.getScreenshotAs(OutputType.FILE); 
    


	  @Test
	  public void  openMyBlog() throws Exception  {
	
		

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
//	 driver.quit();
	  }
	
	
	    }

	


