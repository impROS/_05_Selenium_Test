package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
Makale Link : https://yasinalbakir.net/java-ile-selenium-webdriver-baslangic/
Chrome Driver download link:
* https://googlechromelabs.github.io/chrome-for-testing/#stable
* */
public class LoginPageTest {

    protected WebDriver driver;
    public static String loginUrl = "https://practicetestautomation.com/practice-test-login/";

    @Before
    public void setUp() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/ridvanakar/Downloads/chromedriver-mac-x64/chromedriver");
            driver = new ChromeDriver();
        } catch (Exception e) {
            System.err.println("WebDriver başlatma hatası: " + e.getMessage());
        }
    }

    @Test
    public void correctLogin() {
        try {
            driver.get(loginUrl);
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();
            Assert.assertEquals("Logged In Successfully | Practice Test Automation", driver.getTitle());
        } catch (Exception e) {
            System.err.println("Test senaryosu hatası: " + e.getMessage());
        }
    }

    @Test
    public void incorrectLogin() {
        try {
            driver.get(loginUrl);
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password1234");
            driver.findElement(By.id("submit")).click();
            Assert.assertEquals("Test Login | Practice Test Automation", driver.getTitle());
        } catch (Exception e) {
            System.err.println("Test senaryosu hatası: " + e.getMessage());
        }
    }
    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.err.println("WebDriver kapatma hatası: " + e.getMessage());
        }
    }
}
