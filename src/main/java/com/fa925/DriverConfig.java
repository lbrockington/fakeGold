package com.fa925;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {
    public WebDriver configDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

        return driver;
    }
}
