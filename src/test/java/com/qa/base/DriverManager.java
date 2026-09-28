package com.qa.base;

import java.util.List;

import com.microsoft.playwright.*;

public class DriverManager {
	
	//You can use static but we use ThreadLocal to ensure parallel testing
	//You use Thread Local to ensure that you dont hit race condition
	private static ThreadLocal<Playwright>
	playwright = new ThreadLocal<>();
	
	private static ThreadLocal<Browser>
	browser = new ThreadLocal<>();
	
	private static ThreadLocal<BrowserContext>
	browserContext = new ThreadLocal<>();
	
	private static ThreadLocal<Page>
	page = new ThreadLocal<>();
	
	
	//------------Getters---------------
	public static Playwright getPlaywright() {
		return playwright.get();
	}
	
	public static Browser getBrowser() {
		return browser.get();
	}
	
	public static BrowserContext getcontext() {
		return browserContext.get();
	}
	
	public static Page getPage() {
		return page.get();
	}
	
	
	//----------INITIALIZE BROWSER-----------------
	
	public static void initBrowser(String Browser) {
		playwright.set(Playwright.create());
		
		
		switch(Browser.toLowerCase()) {
		case "chromium":
			browser.set(
					getPlaywright().chromium().launch(
							new BrowserType.LaunchOptions()
											.setHeadless(false)
											.setArgs(List.of("--start-maximized"))));
			break;
		case "firefox":
			browser.set(
					getPlaywright().firefox().launch(
							new BrowserType.LaunchOptions()
											.setHeadless(false)
											.setArgs(List.of("--start-maximized"))));
			break;
			
		case "chrome":
			browser.set(
					getPlaywright().chromium().launch(
							new BrowserType.LaunchOptions()
											.setHeadless(false)
											.setChannel("chrome")
											.setArgs(List.of("--start-maximized"))));
			break;
			
		default:
			System.out.println("You have entered wrong browser. Please enter the correct browser name.....");
			break;
	
		
		}
		
		
		browserContext.set(getBrowser().newContext(new Browser.NewContextOptions()
																.setViewportSize(null)));
		
		page.set(getcontext().newPage());
		
		
	}
	
	public static void closeBrowser() {
		//---CLOSE BROWSER-----------
		if(getPage()!=null) {
			getPage().close();
		}
		
		if(getcontext()!=null) {
			getcontext().close();
		}
		
		if(getBrowser()!=null) {
			getBrowser().close();
		}
		
		if(getPlaywright()!=null) {
			getPlaywright().close();
		}
		
		
	  page.remove();
	  browserContext.remove();
	  browser.remove();
	  playwright.remove();
	}
	

	
	
	
	
	

}
