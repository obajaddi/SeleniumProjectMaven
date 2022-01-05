package testPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class wowTest
{
    @Before
    public void setUp(){
    }

    @After
    public void tearDown() {

    }
//
    @Test
    public void testwowTest() {
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fr.wowhead.com/");
        // Verification titre de la page
        assertTrue(driver.getCurrentUrl().contains("https://fr.wowhead.com/"));
        // Accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // refuse cookies
        driver.findElement(By.xpath("//button[@class='notifications-dialog-buttons-decline btn']")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // search
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Lardeur");
        driver.findElement(By.xpath("//a[@class='header-search-button fa fa-search']")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Select boss
        driver.findElement(By.xpath("//td[@class='icon-boss-padded']/*[1]")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.quit();
    }

/*
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://fr.wowhead.com/");
        // Accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // refuse cookies
        driver.findElement(By.xpath("//button[@class='notifications-dialog-buttons-decline btn']")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // search
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Lardeur");
        driver.findElement(By.xpath("//a[@class='header-search-button fa fa-search']")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Select boss
        driver.findElement(By.xpath("//td[@class='icon-boss-padded']/*[1]")).click();
        // wait of 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }*/
}
