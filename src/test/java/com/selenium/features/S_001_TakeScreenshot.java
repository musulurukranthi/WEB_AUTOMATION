package com.selenium.features;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S_001_TakeScreenshot {
	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("auto-open-devtools-for-tabs"); 
//		options.addArguments("new-window");
		options.addArguments("start-maximized");
		
		
		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		WebElement userName = driver.findElement(By.cssSelector("#input-username"));
		userName.clear();
		userName.sendKeys("demo");
		
		WebElement psWD = driver.findElement(By.cssSelector("#input-password"));
		psWD.clear();
		psWD.sendKeys("demo");
		
		WebElement lgnBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement lgnBtnWaited =  wait.until(ExpectedConditions.elementToBeClickable(lgnBtn));
		lgnBtnWaited.click();
		
		// ###########  Screen Shot Code ####################################
		File dashboard = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(dashboard, new File("./Screenshots/Dashboard.png"));
		
//		driver.close();
		
		
	}

}
