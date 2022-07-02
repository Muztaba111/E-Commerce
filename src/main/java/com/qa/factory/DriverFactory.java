package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		if (browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver());
			
		}else {
			System.out.println("Please enter correct browser" +browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}

}
