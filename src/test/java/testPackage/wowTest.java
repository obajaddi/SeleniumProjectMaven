package testPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class wowTest
{
    protected String os;
    protected String driver_path;
    protected String BROWSER;
    protected WebDriver driver;

    @Before
    public void setUp(){
        BROWSER = "geckodriver";//System.getProperty("browser");
        // Quel OS ?
        os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            driver_path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "win" + File.separator + BROWSER +".exe";
        } else if (os.contains("nux") || os.contains("nix") || os.contains("untu")) {
            driver_path = "src/test/resources/linux/"+BROWSER;
        }

        // Browser choice
        if (BROWSER == "chromedriver") {
            System.setProperty("webdriver.chrome.driver", driver_path);
            driver = new ChromeDriver();
        } else if (BROWSER == "geckodriver"){
            System.setProperty("webdriver.gecko.driver", driver_path);
            driver = new FirefoxDriver();
        }

    }

    @After
    public void tearDown() {

    }
//
    @Test
    public void testwowTest() throws InterruptedException {

        /*
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--window-size=1280,");*/

        driver.get("https://fr.wowhead.com/");
        // Verification titre de la page
        assertTrue(driver.getCurrentUrl().contains("https://fr.wowhead.com/"));
        // wait of 2 seconds
        Thread.sleep(2000);
        // Accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        // wait of 2 seconds
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // refus alertes
        driver.findElement(By.xpath("//button[@class='notifications-dialog-buttons-decline btn']")).click();
        // wait of 2 seconds
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // search
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Lardeur");
        driver.findElement(By.xpath("//a[@class='header-search-button fa fa-search']")).click();
        // wait of 2 seconds
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Select boss
        driver.findElement(By.xpath("//td[@class='icon-boss-padded']/*[1]")).click();
        // wait of 2 seconds
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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
