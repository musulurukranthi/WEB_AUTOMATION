package com.selenium.demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class S_001_Elements_TextBox {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
//	options.addArguments("auto-open-devtools-for-tabs"); 
//	options.addArguments("new-window");
		options.addArguments("start-maximized");

		WebDriver driver = new ChromeDriver(options);
//	driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='card-body']//child::h5[text()='Elements']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		ele.click();

		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		driver.findElement(By.cssSelector("#userName")).sendKeys("Kranthi");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("Kranthi@gmail.com");
		driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Address");
		driver.findElement(By.cssSelector("#permanentAddress")).sendKeys("Permanent Address");
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("#submit")));
		driver.findElement(By.cssSelector("#submit")).click();
		String txt = driver.findElement(By.cssSelector("#name")).getText();
		Assert.assertEquals(txt, "Name:Kranthi");
		System.out.println(txt);
		driver.quit();
		
	}
}
