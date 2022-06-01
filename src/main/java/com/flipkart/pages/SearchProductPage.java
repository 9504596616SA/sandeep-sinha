package com.flipkart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Base.TestBase;

public class SearchProductPage extends TestBase {
	By searchloc=By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
	
	
	public boolean ValidateSearchProduct(String prod) {
		driver.findElement(searchloc).sendKeys(prod);
		wait(2000);
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(searchloc).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[2]")));
		String actuals= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[2]")).getText();
		return actuals.equalsIgnoreCase("laptop");
	}
	
	
	
	
	

}
