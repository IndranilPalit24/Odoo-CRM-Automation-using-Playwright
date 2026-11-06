package com.qa.base;

import com.microsoft.playwright.*;
import com.qa.utils.ConfigReader;
import io.cucumber.java.*;
import io.cucumber.java.*;

public class Hooks {
    @Before
    public void setUp() {
        DriverManager.initBrowser(ConfigReader.getBrowser());
    }

    @After
    public void tearDown() {
        DriverManager.closeBrowser();
    }

	
	
	
	
	

}
