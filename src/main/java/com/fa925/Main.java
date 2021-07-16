package com.fa925;

import org.openqa.selenium.WebDriver;

public class Main {
    private static WebDriver driver = new DriverConfig().configDriver();


    public static void main(String[] args) throws InterruptedException {
        Findfake notReal = new Findfake(driver);
        notReal.findFake();
    }
}
