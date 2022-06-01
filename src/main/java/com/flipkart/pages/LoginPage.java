package com.flipkart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Base.TestBase;

public class LoginPage extends TestBase {
	By emailloc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	By passwordloc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	By loginButtonloc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button");

	public boolean ValidateLogin(String Email, String Pass) {
		boolean loginFlag = true;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(emailloc).sendKeys(Email);
		driver.findElement(passwordloc).sendKeys(Pass);
		driver.findElement(loginButtonloc).click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));

		} catch (Exception e) {
			capturedScreenshot("Login Error");
			loginFlag = false;
		}
		if (loginFlag) {
			WebElement actResult = driver
					.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div"));
			return actResult.getText().equalsIgnoreCase("Sandeep");
		} else
			return loginFlag;
	}

}
