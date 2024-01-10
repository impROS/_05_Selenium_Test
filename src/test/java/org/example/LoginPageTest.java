package org.example;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    protected WebDriver driver;
    public static String loginUrl = "http://45.144.152.4:3000";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/ridvanakar/Downloads/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void correctLogin() {
        driver.get(loginUrl);
        driver.findElement(By.id("kullaniciAdi")).sendKeys("admin");
        driver.findElement(By.id("parola")).sendKeys("123456");
        driver.findElement(By.id("btnGirisYap")).click();
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}