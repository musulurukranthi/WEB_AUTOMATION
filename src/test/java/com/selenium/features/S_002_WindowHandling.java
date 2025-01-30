package com.selenium.features;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S_002_WindowHandling {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("auto-open-devtools-for-tabs"); 
//		options.addArguments("new-window");
		options.addArguments("start-maximized");

		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
}
