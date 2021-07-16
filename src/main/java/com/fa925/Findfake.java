package com.fa925;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Findfake {
    private WebDriver driver;
    private static String firstWeigh;
    private static String secondWeigh;
    private static WebElement weighButton;
    private static WebElement resetButton;

    public Findfake(WebDriver driver) {
        this.driver = driver;
    }


    public void findFake() {
        try{
            driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
            weighButton = driver.findElement(By.xpath("//button[@id='weigh']"));
            resetButton = driver.findElement(By.xpath("//button[contains(text(),'Reset')]"));

            //Entering the initial bars, weighing them and saving their value.
            driver.findElement(By.xpath("//input[@id='left_0']")).sendKeys("1");
            driver.findElement(By.xpath("//input[@id='left_1']")).sendKeys("2");
            driver.findElement(By.xpath("//input[@id='left_2']")).sendKeys("3");
            driver.findElement(By.xpath("//input[@id='right_0']")).sendKeys("4");
            driver.findElement(By.xpath("//input[@id='right_1']")).sendKeys("5");
            driver.findElement(By.xpath("//input[@id='right_2']")).sendKeys("6");
            weighButton.click();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            firstWeigh = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/ol[1]/li[1]")).getText();
            System.out.println("We've weighed bars 1 - 3 vs 4 - 6.");

            if (firstWeigh.contains("=")) {
                equal();
            } else if (firstWeigh.contains("<")) {
                lesser();
            } else {
                greater();
            }
        } catch (Exception e) {
            System.out.println("Unable to connect to site, please check address");
            driver.close();
        }
    }

    //Processing of bars if initial weight is equal between bowls.
    public void equal(){
        resetButton.click();
        driver.findElement(By.xpath("//input[@id='left_0']")).sendKeys("7");
        driver.findElement(By.xpath("//input[@id='right_0']")).sendKeys("8");
        weighButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Weighing the gold bars for the 2 and last time. Weighing bar 7 vs bar 8");
        secondWeigh = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/ol[1]/li[2]")).getText();
        if (secondWeigh.contains("=")) {
            resetButton.click();
            driver.findElement(By.xpath("//button[@id='coin_0']")).click();
            System.out.println("The fake bar was number 0 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else if (secondWeigh.contains("<")) {
            driver.findElement(By.xpath("//button[@id='coin_7']")).click();
            System.out.println("The fake bar was number 7 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else {
            driver.findElement(By.xpath("//button[@id='coin_8']")).click();
            System.out.println("The fake bar was number 8 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        }
        driver.close();
    }

    //Processing of bars if left bowls weight is less then right bowls
    public void lesser(){
        resetButton.click();
        driver.findElement(By.xpath("//input[@id='left_0']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id='right_0']")).sendKeys("3");
        weighButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Weighing the gold bars for the 2 and last time. Weighing bar 1 vs bar 3");
        secondWeigh = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/ol[1]/li[2]")).getText();
        if (secondWeigh.contains("=")) {
            driver.findElement(By.xpath("//button[@id='coin_2']")).click();
            System.out.println("The fake bar was number 2 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else if (secondWeigh.contains(">")) {
            driver.findElement(By.xpath("//button[@id='coin_3']")).click();
            System.out.println("The fake bar was number 3 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else {
            driver.findElement(By.xpath("//button[@id='coin_1']")).click();
            System.out.println("The fake bar was number 1 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        }
        driver.close();
    }

    //Processing of bars if right bowl weight is less then left bowls
    public void greater(){
        resetButton.click();
        driver.findElement(By.xpath("//input[@id='left_0']")).sendKeys("4");
        driver.findElement(By.xpath("//input[@id='right_0']")).sendKeys("6");
        weighButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Weighing the gold bars for the 2 and last time. Weighing bar 4 vs bar 6");
        secondWeigh = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/ol[1]/li[2]")).getText();
        if (secondWeigh.contains("=")) {
            driver.findElement(By.xpath("//button[@id='coin_5']")).click();
            System.out.println("The fake bar was number 5 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else if (secondWeigh.contains(">")) {
            driver.findElement(By.xpath("//button[@id='coin_6']")).click();
            System.out.println("The fake bar was number 6 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        } else {
            driver.findElement(By.xpath("//button[@id='coin_4']")).click();
            System.out.println("The fake bar was number 4 " +driver.switchTo().alert().getText());
            driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            driver.switchTo().alert().accept();
        }
        driver.close();
    }
}

