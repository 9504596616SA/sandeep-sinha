package com.flipkart.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;
	public WebDriverWait wait;
	
	public void launchBrowser() {
		
		String fileName = ".\\src\\main\\resources\\config\\config.properties";
		
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = new Properties();
		
		try {
			  prop.load(fis);
		} catch (IOException e) {
			//TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		
		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	private WebDriver FirefoxDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public void wait(int time) {
		try {
			    Thread.sleep(3000);
		} catch (InterruptedException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void capturedScreenshot(String screenName) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String dateTime = sdf.format(date);
		String fileName = ".\\src\\test\\resources\\Screenshots\\screenshots_" + dateTime + ".png";
		
		System.out.println("This is the screenshot for the screen = " + screenName);
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileName);
		
		try {
				FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
